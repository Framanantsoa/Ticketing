<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.models.Avion" %>
<%
    List<Avion> avions = (List<Avion>)request.getAttribute("avions");
%>

<%@ include file="/views/template/head.jsp" %>
<%@ include file="/views/template/header2.jsp" %>

<div class="container-fluid min-vh-100 py-5" style="background-color: #f8f5f0; padding-top: 60px;">
    <div class="container py-5">
        <h2 class="mb-5 text-center font-montserrat-bold" style="color:#2c3e50;">Liste des Avions</h2>

        <div class="row g-4">
            <% if (avions != null && !avions.isEmpty()) { 
                for (Avion avion : avions) { %>
                    <div class="col-sm-6 col-md-4 col-lg-3">
                        <div class="card h-100 shadow border-0 rounded-3"
                             style="background-color: bisque; transition: transform 0.3s, box-shadow 0.3s;">
                            <div class="card-body text-center">
                            <!-- Icône d'avion -->
                                <i class="bi bi-airplane-fill mb-3" style="font-size: 2.5rem; color: #1a1a2e;"></i>
                            <!-- Nom de l'avion -->
                                <h5 class="card-title font-montserrat" style="color: navy;"><%= avion.getNomAvion() %></h5>
                            <!-- Détails des sièges -->
                                <p class="card-text font-lora" style="color:#34495e;">
                                    <strong>Économique :</strong> <%= avion.getSiegeEconomique() %> sièges<br>
                                    <strong>Business :</strong> <%= avion.getSiegeBusiness() %> sièges<br>
                                    <strong>Total :</strong> <%= avion.getSiegeEconomique() + avion.getSiegeBusiness() %> sièges
                                </p>
                            </div>
                        </div>
                    </div>
            <% } 
            } else { %>
                <div class="col-12 text-center font-lora" style="color:#7f8c8d;">
                    Aucun avion trouvé.
                </div>
            <% } %>
        </div>
    </div>
</div>

<script>
    // Hover effect pour les cartes
    document.querySelectorAll('.card').forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.transform = 'translateY(-5px)';
            card.style.boxShadow = '0 8px 20px rgba(0,0,0,0.2)';
        });
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'translateY(0)';
            card.style.boxShadow = '0 4px 12px rgba(0,0,0,0.1)';
        });
    });
</script>

<%@ include file="/views/template/footer.jsp" %>
<%@ include file="/views/template/foot.jsp" %>
