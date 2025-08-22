<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav id="mainNavbar" class="bg-dark text-white navbar navbar-expand-lg navbar-dark position-fixed w-100 py-3 shadow-sm"
 style="background: rgba(0, 0, 0, 0.95); z-index: 5;">
    <div class="container">
      <a class="navbar-brand d-flex align-items-center font-montserrat-bold" href="/Ticketing/accueil">
        <img src="http://localhost:3000/img/logo.png" alt="Logo" height="30" class="me-2">
        AENUM
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto font-montserrat">
          <li class="nav-item"><a class="nav-link" href="/Ticketing/accueil">Accueil</a></li>

          <!-- Dropdown Réservation -->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="reservationDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Réservation
            </a>
            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="reservationDropdown">
              <li><a class="dropdown-item" href="/Ticketing/reservations/liste">Liste</a></li>
              <li><a class="dropdown-item" href="/Ticketing/reservations/saisie">Nouvelle</a></li>
            </ul>
          </li>

          <li class="nav-item"><a class="nav-link" href="/Ticketing/vols">Vols</a></li>
          <li class="nav-item"><a class="nav-link" href="/Ticketing/avions">Nos avions</a></li>
          <li class="nav-item"><a class="nav-link" href="/Ticketing/trajets">Trajets</a></li>
        </ul>
      </div>
    </div>
</nav>
