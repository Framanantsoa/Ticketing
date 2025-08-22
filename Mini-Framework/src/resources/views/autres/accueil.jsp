<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/views/template/head.jsp" %>

<!-- Navbar -->
<%@ include file="/views/template/header.jsp" %>

<!-- Hero Section -->
<header class="d-flex align-items-center justify-content-center text-center"
 style="height: 100vh; 
 background: url('http://localhost:3000/img/bg2.jpg') no-repeat center center; 
 background-size: cover;">
    <div class="text-white">
        <h1 class="display-3 font-montserrat-bold">Bienvenue sur AENUM</h1>
        <p class="lead font-lora">Réservez vos vols facilement et rapidement.</p>
    </div>
</header>

<%@ include file="/views/template/footer.jsp" %>

<script>
    // Navbar transparent -> background léger au scroll
    window.addEventListener('scroll', () => {
    const navbar = document.getElementById('mainNavbar');
    if (window.scrollY > 30) {
        navbar.style.background = 'rgba(0, 0, 0, 0.95)';
    } else {
        navbar.style.background = 'transparent';
    }
    });
</script>

<%@ include file="/views/template/foot.jsp" %>
