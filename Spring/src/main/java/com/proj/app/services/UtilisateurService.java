package com.proj.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.app.entities.Utilisateur;
import com.proj.app.repositories.UtilisateurRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UtilisateurService 
{
    @Autowired
    private UtilisateurRepo repo;

    private ConcurrentHashMap<String, Long> tokenStore = new ConcurrentHashMap<>();


    public String logUser(String email, String pwd) {
        Utilisateur user = repo.logAdmin(email, pwd);
        if (user == null) return null;

        String token = UUID.randomUUID().toString();
        tokenStore.put(token, user.getIdUtilisateur());
        return token;
    }

    public Utilisateur logSimpleUser(String email, String pwd) {
        Utilisateur user = repo.logSimpleUser(email, pwd);
        if (user == null) return null;

        return user;
    }


    public Long verifyToken(String token) {
        return tokenStore.get(token);
    }


    public void logout(String token) {
        tokenStore.remove(token);
    }


    public String getToken(HttpServletRequest request) {
        // Vérification du token comme pour dashboard
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("TOKEN".equals(c.getName())) {
                    token = c.getValue();
                }
            }
        }
        
        return token;
    }
}
