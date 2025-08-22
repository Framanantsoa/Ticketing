package com.repositories;

import com.models.Utilisateur;
import javax.persistence.EntityManager;

public class UtilisateurRepo extends Repository 
{
    public UtilisateurRepo(EntityManager em) {
        super(em);
    }

    public Utilisateur isValidLogin(String email, String pwd) throws RuntimeException {
        Utilisateur user = new Utilisateur();
        try {
            user = (Utilisateur) getEntityManager().createNativeQuery(
             "SELECT * FROM utilisateurs WHERE email=:email "+
             "AND mot_de_passe=crypt(:pwd, mot_de_passe)",
             Utilisateur.class
            ).setParameter("email", email).setParameter("pwd", pwd)
            .getSingleResult();
        } 
        catch(RuntimeException e) {
            throw new RuntimeException("Email ou mot de passe invalide !");
        }
        return user;
    }
}
