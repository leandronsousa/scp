package br.com.stefanini.scp.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	@Produces
    @PersistenceContext(unitName="primary")
    private EntityManager em;

//    @Produces
//    public Logger produceLog(InjectionPoint injectionPoint) {
//        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
//    }
//
//    @Produces
//    @RequestScoped
//    public FacesContext produceFacesContext() {
//        return FacesContext.getCurrentInstance();
//    }
	
}
