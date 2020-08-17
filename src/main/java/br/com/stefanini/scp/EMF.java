package br.com.stefanini.scp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener {
	
	public static final String JPA_UNIT = "primary";
	
	private static EntityManagerFactory emf;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory(JPA_UNIT);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		emf.close();
	}
	
	public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }

}
