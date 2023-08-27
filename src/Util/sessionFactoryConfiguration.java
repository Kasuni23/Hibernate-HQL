package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sessionFactoryConfiguration {
    private static sessionFactoryConfiguration SessionFactoryConfiguration;

    private SessionFactory sessionFactory;

    private sessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure();

        sessionFactory = configuration.buildSessionFactory();
    }

    public static sessionFactoryConfiguration getInstance() {
        return SessionFactoryConfiguration == null ? SessionFactoryConfiguration = new sessionFactoryConfiguration()
                : SessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
