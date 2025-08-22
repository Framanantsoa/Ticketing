package com.repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.dto.ReservationViewDto;

public class ReservationRepo extends Repository
{
    public ReservationRepo(EntityManager em) {
        super(em);
    }


    public List<ReservationViewDto> getAllReservations() {
        String sql = "SELECT r.id_reservation, r.cin, r.telephone, r.nombre_place, "+
            "r.nombre_enfant, s.nom_statut, "+
            "v1.nom_ville ||' -- '|| v2.nom_ville || ' # ' || v.date_depart as trajet "+
            "from reservations r JOIN statuts s ON r.id_statut=s.id_statut "+
            "JOIN vols v ON r.id_vol=v.id_vol JOIN trajets t ON v.id_trajet=t.id_trajet "+
            "JOIN villes v1 ON t.id_depart=v1.id_ville "+
            "JOIN villes v2 ON t.id_arrivee=v2.id_ville WHERE r.id_statut=:idStat "+
            "ORDER BY r.id_reservation DESC";

        List<Object[]> rows = getEntityManager()
            .createNativeQuery(sql)
            .setParameter("idStat", 2L)
            .getResultList();

        List<ReservationViewDto> results = new ArrayList<>();
        for (Object[] row : rows) {
            ReservationViewDto dto = new ReservationViewDto(
                ((Number) row[0]).longValue(),   // idReservation
                (String) row[1],                // cin
                (String) row[2],                // telephone
                ((Number) row[3]).intValue(),   // nombre_place
                ((Number) row[4]).intValue(),   // nombre_enfant
                (String) row[5],                // statut
                (String) row[6]                 // trajet
            );
            results.add(dto);
        }

        return results;
    }

}
