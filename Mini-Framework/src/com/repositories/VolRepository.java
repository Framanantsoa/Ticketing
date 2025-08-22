package com.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import com.models.Vol;

public class VolRepository extends Repository
{
    public VolRepository(EntityManager em) {
        super(em);
    }

    
    public List<Vol> getAllVols() {
        String sql = "SELECT v FROM Vol v";
    
        return getEntityManager()
         .createQuery(sql, Vol.class).getResultList();
    }

    public Vol getVolById(Long id) {
        String jpql = "SELECT v FROM Vol v WHERE v.idVol = :id";
    
        return getEntityManager()
                .createQuery(jpql, Vol.class)
                .setParameter("id", id)
                .getSingleResult();
    }    


    public int getSiegeEcoLibre(Long idVol) {
        String sql = "SELECT a.siege_economique - COALESCE((" +
             "    SELECT SUM(r.place_economique) " +
             "    FROM reservations r " +
             "    WHERE r.id_vol = v.id_vol" +
             "), 0) AS reste " +
             "FROM vols v " +
             "JOIN avions a ON v.id_avion = a.id_avion " +
             "WHERE v.id_vol = :idVol";
    
        Object result = getEntityManager()
                .createNativeQuery(sql)
                .setParameter("idVol", idVol)
                .getSingleResult();
    
        return ((Number) result).intValue();
    }    

    public int getSiegeBusLibre(Long idVol) {
        String sql = "SELECT a.siege_business - COALESCE((" +
             "    SELECT SUM(r.place_business) " +
             "    FROM reservations r " +
             "    WHERE r.id_vol = v.id_vol" +
             "), 0) AS reste " +
             "FROM vols v " +
             "JOIN avions a ON v.id_avion = a.id_avion " +
             "WHERE v.id_vol = :idVol";
    
        Object result = getEntityManager()
                .createNativeQuery(sql)
                .setParameter("idVol", idVol)
                .getSingleResult();
    
        return ((Number) result).intValue();
    }
}
