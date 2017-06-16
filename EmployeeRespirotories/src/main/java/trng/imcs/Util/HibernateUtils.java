package trng.imcs.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

 
public class HibernateUtils {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
   
    
    private static SessionFactory buildSessionFactory() {
		try {
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
	            return sessionFactory;
		} catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

