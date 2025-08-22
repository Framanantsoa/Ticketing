package com.proj.app.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proj.app.services.UtilisateurService;

@Controller
public class AuthController 
{
    @Autowired
    private UtilisateurService service;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response,
     String email, String motDePasse, Model model) {
        String token = service.logUser(email, motDePasse);
        if (token == null) {
            model.addAttribute(
                "error", 
                "Email ou mot de passe incorrect");
            return "login";
        }

        Cookie cookie = new Cookie("TOKEN", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60); // 1h
        response.addCookie(cookie);

        return "redirect:/accueil";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("TOKEN", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        // Supprime du tokenStore
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if("TOKEN".equals(c.getName())){
                    service.logout(c.getValue());
                }
            }
        }

        return "redirect:/login";
    }


    @GetMapping("/accueil")
    public String accueil(HttpServletRequest request, Model model) {
        String token = this.service.getToken(request);
        // Si pas de token ou invalide → login
        if (token == null || service.verifyToken(token) == null) {
            return "redirect:/login";
        }

        // Sinon on affiche accueil.html
        model.addAttribute("userId", service.verifyToken(token));
        return "accueil"; // ça va chercher templates/accueil.html
    }
}
