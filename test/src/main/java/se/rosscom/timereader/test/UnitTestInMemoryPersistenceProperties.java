package se.rosscom.timereader.test;

import java.util.Properties;

public class UnitTestInMemoryPersistenceProperties {
    public static Properties getInMemoryPersistenceProperties() {
        Properties override = new Properties();

        override.put("javax.persistence.jdbc.driver", org.h2.Driver.class.getName());
        override.put("javax.persistence.jdbc.url", "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE");
        override.put("javax.persistence.jdbc.user", "sa");
        override.put("javax.persistence.jdbc.password", "");

        override.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        override.put("hibernate.hbm2ddl.auto", "create-drop");

        override.put("hibernate.search.default.directory_provider", "ram");
        return override;
    }
}
