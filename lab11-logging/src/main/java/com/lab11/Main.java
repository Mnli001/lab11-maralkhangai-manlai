package com.lab11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("========== ПРОГРАМ ЭХЭЛЛЭА ==========");

        BankAccount account = new BankAccount(1000.0);

        logger.info("--- Туршилт 1: Хэвийн хийлт ---");
        account.deposit(500.0);

        logger.info("--- Туршилт 2: Хэвийн авалт ---");
        account.withdraw(200.0);

        logger.info("--- Туршилт 3: Сөрөг дүн оруулах (WARN хүлээгдэж байна) ---");
        account.deposit(-100.0);

        logger.info("--- Туршилт 4: Үлдэгдэлээс их авалт (ERROR хүлээгдэж байна) ---");
        account.withdraw(999999.0);

        logger.info("--- Туршилт 5: Эцсийн үлдэгдэл шалгах ---");
        double bal = account.getBalance();
        logger.info("Эцсийн үлдэгдэл: {}", bal);

        logger.info("--- Туршилт 6: FATAL симуляц ---");
        account.simulateFatalError();

        logger.info("--- Туршилт 7: Нууц мэдээлэл маскалах ---");
        account.logSensitiveAction("1234567890123456");

        logger.info("========== CUSTOMER ТУРШИЛТ ==========");

        Customer c1 = new Customer("Болд", "bold@gmail.com");
        logger.info("{} -ийн домэйн: {}", c1.getName(), c1.getDomain());

        Customer c2 = new Customer("Гүндэгмаа", null);
        logger.info("{} -ийн домэйн: {}", c2.getName(), c2.getDomain());

        Customer c3 = new Customer("Дорж", "dorj-email-buruu");
        logger.info("{} -ийн домэйн: {}", c3.getName(), c3.getDomain());

        logger.info("========== ПРОГРАМ ДУУСЛАА ==========");
    }
}
