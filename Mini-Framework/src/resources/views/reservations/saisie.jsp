<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.exceptions.ValidationException" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.models.Vol" %>

<%
    ValidationException errors = (ValidationException) request.getAttribute("validationErrors");
    List<Vol> vols = (List<Vol>) request.getAttribute("vols");
    String idVolParam = request.getParameter("idVol");
    Long volSelected = null;

    if (idVolParam != null && !idVolParam.isEmpty()) {
        try {
            volSelected = Long.parseLong(idVolParam);
        } catch (NumberFormatException e) {
            // Gérer l'erreur : valeur invalide
            volSelected = null;
        }
    }
%>

<%@ include file="/views/template/head.jsp" %>
<%@ include file="/views/template/header2.jsp" %>

<!-- Section principale -->
<div class="container-fluid min-vh-100 d-flex align-items-center" style="background-color: #ffffff; padding-top: 60px;">
    <div class="container py-5">
        <div class="row align-items-center">
            <!-- Formulaire -->
            <div class="col-lg-6 mb-4 mb-lg-0">
                <div class="card shadow p-4 border-0 bg-dark text-white">
                    <h3 class="mb-4 font-montserrat-bold text-center">Réserver un vol</h3>
                    <form action="/Ticketing/reservations/soumission" method="post" class="font-lora">
                        <div class="mb-3">
                            <label for="nom_complet" class="form-label font-lora-bold">Nom complet</label>
                            <input type="text" class="form-control border-0" id="nom_complet" name="nomComplet"
                             value='<%= request.getParameter("nomComplet")!=null ? request.getParameter("nomComplet"):"" %>'>

                            <% if (errors != null && errors.getFieldErrors("nomComplet") != null) {
                                for (String error : errors.getFieldErrors("nomComplet")) { %>
                                    <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                <% }
                            } %>
                        </div>
                        <div class="mb-3">
                            <label for="cin" class="form-label font-lora-bold">CIN</label>
                            <input type="text" class="form-control border-0" id="cin" name="cin"
                             value='<%= request.getParameter("cin")!=null ? request.getParameter("cin"):"" %>'>

                            <% if (errors != null && errors.getFieldErrors("cin") != null) {
                                for (String error : errors.getFieldErrors("cin")) { %>
                                    <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                <% }
                            } %>
                        </div>
                        <div class="mb-3">
                            <label for="telephone" class="form-label font-lora-bold">Téléphone</label>
                            <input type="tel" class="form-control border-0" id="telephone" name="telephone"
                             value='<%= request.getParameter("telephone")!=null ? request.getParameter("telephone"):"" %>'>

                            <% if (errors != null && errors.getFieldErrors("telephone") != null) {
                                for (String error : errors.getFieldErrors("telephone")) { %>
                                    <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                <% }
                            } %>
                        </div>
                        <div class="mb-3 row">
                            <div class="col">
                                <label for="nombre_place" class="form-label font-lora-bold">Places totales</label>
                                <input type="number" class="form-control border-0" id="nombre_place" name="nombrePlace" min="1"
                                 value='<%= request.getParameter("nombrePlace")!=null ? request.getParameter("nombrePlace"):"" %>'>

                                <% if (errors != null && errors.getFieldErrors("nombrePlace") != null) {
                                    for (String error : errors.getFieldErrors("nombrePlace")) { %>
                                        <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                    <% }
                                } %>
                            </div>
                            <div class="col">
                                <label for="nombre_enfant" class="form-label font-lora-bold">Enfants</label>
                                <input type="number" class="form-control border-0" id="nombre_enfant" name="nombreEnfant" min="0"
                                 value='<%= request.getParameter("nombreEnfant")!=null ? request.getParameter("nombreEnfant"):"" %>'>

                                <% if (errors != null && errors.getFieldErrors("nombreEnfant") != null) {
                                    for (String error : errors.getFieldErrors("nombreEnfant")) { %>
                                        <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                    <% }
                                } %>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <div class="col">
                                <label for="place_business" class="form-label font-lora-bold">Places Business</label>
                                <input type="number" class="form-control border-0" id="place_business" name="placeBusiness" min="0"
                                 value='<%= request.getParameter("placeBusiness")!=null ? request.getParameter("placeBusiness"):"" %>'>

                                <% if (errors != null && errors.getFieldErrors("placeBusiness") != null) {
                                    for (String error : errors.getFieldErrors("placeBusiness")) { %>
                                        <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                    <% }
                                } %>
                            </div>
                            <div class="col">
                                <label for="place_economique" class="form-label font-lora-bold">Places Économiques</label>
                                <input type="number" class="form-control border-0" id="place_economique" name="placeEconomique" min="0"
                                 value='<%= request.getParameter("placeEconomique")!=null ? request.getParameter("placeEconomique"):"" %>'>

                                <% if (errors != null && errors.getFieldErrors("placeEconomique") != null) {
                                    for (String error : errors.getFieldErrors("placeEconomique")) { %>
                                        <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                    <% }
                                } %>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="id_vol" class="form-label font-lora-bold">Vol</label>
                            <select class="form-select border-0" id="id_vol" name="idVol">
                                <option value=''>Sélectionner un vol</option>
                                <% for (Vol vol : vols) { %>
                                    <option value='<%=vol.getIdVol()%>' <%= (volSelected!=null && volSelected == vol.getIdVol() ) ? "selected" : "" %>>
                                        <%= vol.getTrajet().getDepart().getNomVille() %> -- 
                                        <%= vol.getTrajet().getArrivee().getNomVille() %> le 
                                        <%= vol.getDateDepart() %>
                                    </option>
                                <% } %>
                            </select>

                            <% if (errors!=null && errors.getFieldErrors("idVol")!=null) {
                                for (String error : errors.getFieldErrors("idVol")) { %>
                                    <div class="alert alert-danger text-center" role="alert"><p><%=error%></p></div>
                                <% }
                            } %>
                        </div>
                        <button type="button" class="btn btn-primary font-montserrat-bold" 
                            data-bs-toggle="modal" data-bs-target="#loginModal">Réserver
                        </button>
                        <!-- LOGIN -->
                        <%@ include file="/views/template/login-modal.jsp" %>

                        <!-- input caché pour stocker l’id utilisateur -->
                        <input type="hidden" name="idUtilisateur" id="idUtilisateur">
                    </form>
                </div>
            </div>

            <!-- Image -->
            <div class="col-lg-6 text-center">
                <img src="http://localhost:3000/img/reservation2.jpg" alt="Réservation" class="img-fluid rounded shadow-lg">
                <!-- <img src="http://localhost:3000/img/reservation.jpg" alt="Réservation" class="img-fluid rounded shadow-lg mt-2"> -->
            </div>
        </div>
    </div>
</div>

<%@ include file="/views/template/footer.jsp" %>
<script>
    function loginAndSubmit() {
        const email = document.getElementById("email").value;
        const mdp = document.getElementById("password").value;
    
        fetch("http://localhost:8081/api/clients/login", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({email: email, motDePasse: mdp})
        })
        .then(res => res.json())
        .then(data => {
            if (data.success) {
                // injecte l'id utilisateur dans le form
                document.getElementById("idUtilisateur").value = data.idUtilisateur;
                document.querySelector("form").submit();
            } else {
                alert("Email ou mot de passe incorrect !");
            }
        })
        .catch(err => alert("Erreur serveur : " + err));
    }
</script>
    
<%@ include file="/views/template/foot.jsp" %>
