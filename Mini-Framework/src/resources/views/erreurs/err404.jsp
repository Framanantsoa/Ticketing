<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
%>

<%@ include file="/views/template/head.jsp" %>

<div class="container d-flex flex-column justify-content-center
 align-items-center vh-100 text-center font-montserrat bg-light">
    <h1 class="display-1 text-warning font-montserrat-bold">404</h1>

    <h2 class="mb-3 font-lora-bold">Page non trouvée</h2>

    <p class="lead font-lora"><%=message%></p>
    <a href="/Ticketing" class="btn btn-primary mt-3
     font-montserrat-bold">Retour à l'accueil</a>
</div>

<%@ include file="/views/template/foot.jsp" %>
