<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/views/template/head.jsp" %>

<div class="container py-5">
    <div class="form-box">
        <h4 class="mb-4 text-center font-montserrat">
            <i class="bi bi-person-circle me-2"></i>Connexion sur AENUM
        </h4>

        <form action="/Ticketing/login" method="post">
            <div class="mb-3">
                <label for="email" class="form-label font-lora-bold">Email</label>
                <input type="email" class="form-control font-lora" id="email"
                 value="rakoto.alain@gmail.com" name="email" required>
            </div>
            <div class="mb-3">
                <label for="pwd" class="form-label font-lora-bold">Mot de passe</label>
                <div class="input-group">
                    <input type="password" class="form-control font-lora" id="pwd"
                     value="rakoto" name="pwd" required>
                    <span class="input-group-text">
                        <input type="checkbox" id="togglePwd" title="Afficher/Masquer">
                    </span>
                </div>
            </div>
            <button type="submit" class="btn btn-success w-100 mt-3 font-montserrat-bold">
                <i class="bi bi-box-arrow-in-right me-1"></i>Se connecter
            </button>
        </form>              
    </div>
</div>

<%@ include file="/views/template/foot.jsp" %>
