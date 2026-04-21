package com.lab11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    private static final Logger logger = LogManager.getLogger(BankAccount.class);

    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        logger.info("BankAccount үүслэ. Эхний үлдэгдэл: {}", initialBalance);
    }

    public void deposit(double amount) {

        logger.trace(">>> deposit() руу орлоо. amount={}", amount);

        if (amount < 0) {
            logger.warn("Буруу оролт: amount={} сөрөг байна. Үйлдэл цуцлагдлаа.", amount);
            return;
        }

        if (amount == 0) {
            logger.warn("Тэг хэмжээний мөнгө хийх гэж байна. Үйлдэл цуцлагдлаа.");
            return;
        }

        logger.debug("Хийхийн өмнөх үлдэгдэл: {}", balance);

        balance += amount;

        logger.info("Амжилттай хийлэн. Дүн={}, Шинэ үлдэгдэл={}", amount, balance);

        logger.trace("<<< deposit() -аас гарлаа.");
    }

    public void withdraw(double amount) {

        logger.trace(">>> withdraw() руу орлоо. amount={}", amount);

        if (amount < 0) {
            logger.warn("Буруу оролт: amount={} сөрөг байна. Үйлдэл цуцлагдлаа.", amount);
            return;
        }

        logger.debug("Авахын өмнөх үлдэгдэл: {}", balance);

        if (amount > balance) {
            logger.error("Үлдэгдэл хүрэлцэхгүй! Авах гэсэн={}, Одоогийн үлдэгдэл={}", amount, balance);

            return;
        }

        balance -= amount;

        logger.info("Амжилттай авлаа. Дүн={}, Шинэ үлдэгдэл={}", amount, balance);

        logger.trace("<<< withdraw() -аас гарлаа.");
    }

    public double getBalance() {
        logger.trace("getBalance() дуудагдлаа. Буцааж буй утга: {}", balance);
        return balance;
    }

    public void simulateFatalError() {
        logger.fatal("КРИТИК АЛДАА: Тохиргооны файл олдсонгүй! Систем зогсоно.");

    }

    private static String mask(String s) {
        if (s == null || s.length() < 4) return "***";
        return s.substring(0, 2) + "***" + s.substring(s.length() - 2);
    }

    public void logSensitiveAction(String cardNumber) {
        logger.info("Картаар үйлдэл хийлэн: {}", mask(cardNumber));
    }
}
