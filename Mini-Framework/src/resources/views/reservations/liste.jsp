<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dto.ReservationViewDto" %>
<%
    List<ReservationViewDto> reservations = (List<ReservationViewDto>)request.getAttribute("reservations");
%>

<%@ include file="/views/template/head.jsp" %>
<%@ include file="/views/template/header2.jsp" %>

<div class="container-fluid min-vh-100 py-5" style="background-color: #f8f5f0; padding-top: 60px;">
    <div class="container py-5">
        <h2 class="mb-5 text-center font-montserrat-bold" style="color:#2c3e50;">Liste des réservations</h2>

        <div class="table-responsive shadow rounded-3 bg-white p-3">
            <table class="table table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">CIN</th>
                        <th scope="col">Télephone</th>
                        <th scope="col">Sièges</th>
                        <th scope="col">Enfants</th>
                        <th scope="col">Statut</th>
                        <th scope="col">Trajet et Départ</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (reservations != null && !reservations.isEmpty()) { 
                        for (ReservationViewDto dto : reservations) { %>
                            <tr>
                                <td class="font-lora"><%= dto.getCin() %></td>
                                <td class="font-lora"><%= dto.getTelephone() %></td>
                                <td class="font-lora text-end"><%= dto.getSieges() %></td>
                                <td class="font-lora text-end"><%= dto.getEnfants() %></td>
                                <td class="font-lora"><%= dto.getStatut() %></td>
                                <td class="font-lora"><%= dto.getTrajet() %></td>
                            </tr>
                    <%   } 
                    } else { %>
                        <tr>
                            <td colspan="5" class="text-center font-lora" style="color:#7f8c8d;">Aucune réservation trouvée.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/views/template/footer.jsp" %>
<%@ include file="/views/template/foot.jsp" %>
