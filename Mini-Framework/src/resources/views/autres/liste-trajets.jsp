<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dto.TrajetDTO" %>
<%
    List<TrajetDTO> trajets = (List<TrajetDTO>)request.getAttribute("trajets");
%>

<%@ include file="/views/template/head.jsp" %>
<%@ include file="/views/template/header2.jsp" %>

<div class="container-fluid min-vh-100 py-5" style="background-color: #f8f5f0; padding-top: 60px;">
    <div class="container py-5">
        <h2 class="mb-5 text-center font-montserrat-bold" style="color:#2c3e50;">Liste des trajets</h2>

        <div class="table-responsive shadow rounded-3 bg-white p-3">
            <table class="table table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Départ</th>
                        <th scope="col">Arrivée</th>
                        <th scope="col">Frais (Adulte)</th>
                        <th scope="col">Frais (Enfant)</th>
                        <th scope="col">Frais business</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (trajets != null && !trajets.isEmpty()) { 
                        for (TrajetDTO trajet : trajets) { %>
                            <tr>
                                <th scope="row"><%= trajet.getIdTrajet() %></th>
                                <td class="font-lora"><%= trajet.getVilleDepart() %> (<%= trajet.getPaysDepart() %>)</td>
                                <td class="font-lora"><%= trajet.getVilleArrivee() %> (<%= trajet.getPaysArrivee() %>)</td>
                                <td class="font-lora text-end" style="color:#27ae60;"><%= String.format("%,.2f", trajet.getFraisEconomique()) %> Eur</td>
                                <td class="font-lora text-end" style="color:#27ae60;"><%= String.format("%,.2f", trajet.getFraisEnfant()) %> Eur</td>
                                <td class="font-lora text-end" style="color:#2980b9;"><%= String.format("%,.2f", trajet.getFraisBusiness()) %> Eur</td>
                            </tr>
                    <%   } 
                    } else { %>
                        <tr>
                            <td colspan="5" class="text-center font-lora" style="color:#7f8c8d;">Aucun trajet trouvé.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/views/template/footer.jsp" %>
<%@ include file="/views/template/foot.jsp" %>
