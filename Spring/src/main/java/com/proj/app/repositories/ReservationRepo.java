package com.proj.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>
{
    List<Reservation> findAllByOrderByIdReservationDesc();

    @Query(value = "SELECT r.* FROM reservations r " +
        "JOIN statuts s ON r.id_statut=s.id_statut " +
        "WHERE s.nom_statut=:nom " +
        "ORDER BY r.id_reservation DESC", nativeQuery = true
    )
    List<Reservation> findByNomStatut(@Param("nom") String nomStatut);
}
