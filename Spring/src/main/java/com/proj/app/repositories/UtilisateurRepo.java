package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.proj.app.entities.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> 
{
    @Query(value="SELECT * FROM utilisateurs WHERE id_role=1 AND"+
        " email=:email AND mot_de_passe=crypt(:mdp, mot_de_passe)",
        nativeQuery=true)
    Utilisateur logAdmin(
        @Param("email") String email, @Param("mdp") String mdp
    );


    @Query(value="SELECT * FROM utilisateurs WHERE"+
        " email=:email AND mot_de_passe=crypt(:mdp, mot_de_passe)",
        nativeQuery=true)
    Utilisateur logSimpleUser(
        @Param("email") String email, @Param("mdp") String mdp
    );
}
