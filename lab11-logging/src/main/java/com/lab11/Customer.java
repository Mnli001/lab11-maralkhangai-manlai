package com.lab11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer {

    private static final Logger logger = LogManager.getLogger(Customer.class);

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        logger.debug("Customer үүслэ: name={}, email={}", name, email);
    }
    public String getDomain() {

        logger.trace(">>> getDomain() дуудагдлаа. email={}", email);

        if (email == null) {
            logger.warn("email утга null байна. getDomain() ажиллахгүй. 'UNKNOWN' буцаана.");
            return "UNKNOWN";
        }

        if (!email.contains("@")) {
            logger.warn("email буруу формат байна: {}. 'INVALID' буцаана.", email);
            return "INVALID";
        }

        int atIndex = email.indexOf("@");
        logger.debug("@ тэмдэгтийн байрлал: {}", atIndex);

        String domain = email.substring(atIndex + 1).toUpperCase();
        logger.debug("Олдсон домэйн: {}", domain);

        logger.trace("<<< getDomain() буцаж байна: {}", domain);
        return domain;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
