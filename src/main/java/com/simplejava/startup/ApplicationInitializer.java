package com.simplejava.startup;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplejava.client.CreditCardApplicationBeanValidator;
import com.simplejava.client.ValidationResult;
import com.simplejava.dto.CreditCardApplication;
import com.simplejava.util.CustomJsonResourceLoader;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 11:08 PM
 */
@Component
public class ApplicationInitializer implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class); // Logger for logging errors


    private final CustomJsonResourceLoader customJsonResourceLoader;
    private final ObjectMapper objectMapper;
    private final CreditCardApplicationBeanValidator creditCardApplicationBeanValidator;

    public ApplicationInitializer(CustomJsonResourceLoader customJsonResourceLoader, ObjectMapper objectMapper, CreditCardApplicationBeanValidator creditCardApplicationBeanValidator) {
        LOG.info("Initializing ApplicationInitializer");
        this.customJsonResourceLoader = customJsonResourceLoader;
        this.objectMapper = objectMapper;
        this.creditCardApplicationBeanValidator = creditCardApplicationBeanValidator;
    }

    @PostConstruct
    void initialize() {
        LOG.info("ApplicationInitializer initialized in postConstruct");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    @Override
    public void run(String... args) throws Exception {

        //  First read valid application file
        String validCreditCardApplicationFile = "data/validApplication.json";

        CreditCardApplication application = customJsonResourceLoader.convertJsonToApplication(validCreditCardApplicationFile);
        LOG.info(" Credit Card Application Object: {}", application);
        // Validate the application
        ValidationResult validationResult = creditCardApplicationBeanValidator.validate(application);

        LOG.info("validationResult ::: {}", validationResult);

        // Now read invalid application file
        String invalidCreditCardApplicationFileMissingRequiredFields = "data/invalidApplication-missing-required-fields.json";

        CreditCardApplication applicationWithoutRequiredFields = customJsonResourceLoader.convertJsonToApplication(invalidCreditCardApplicationFileMissingRequiredFields);
        LOG.info(" Credit Card Application Object: {}", applicationWithoutRequiredFields);
        // Validate the application
        ValidationResult validationResultForMissingRequiredFields = creditCardApplicationBeanValidator.validate(applicationWithoutRequiredFields);

        LOG.info("validationResult ::: {}", validationResultForMissingRequiredFields);

        // Now read another invalid application file
        String invalidCreditCardApplicationFileRepeatedSSN = "data/invalidApplication-repeated-ssn.json";

        CreditCardApplication applicationWithRepeatedSSN = customJsonResourceLoader.convertJsonToApplication(invalidCreditCardApplicationFileRepeatedSSN);
        LOG.info(" Credit Card Application Object: {}", applicationWithRepeatedSSN);
        // Validate the application
        ValidationResult validationResultForRepeatedSSN = creditCardApplicationBeanValidator.validate(applicationWithRepeatedSSN);

        LOG.info("validationResult ::: {}", validationResultForRepeatedSSN);

    }
}
