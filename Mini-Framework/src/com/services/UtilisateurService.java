package com.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.models.Utilisateur;
import com.repositories.UtilisateurRepo;

public class UtilisateurService extends Service
{
    private EntityManagerFactory emf = this.getEntityManagerFact();

    public Utilisateur loginUser(String email, String pwd) throws RuntimeException {
        EntityManager em = emf.createEntityManager();
        Utilisateur usr = new Utilisateur();
        try {
            UtilisateurRepo repo = new UtilisateurRepo(em);
            usr = repo.isValidLogin(email, pwd);
        } catch(RuntimeException e) {
            throw e;
        } finally { em.close(); }
        
        return usr;
    }
}
