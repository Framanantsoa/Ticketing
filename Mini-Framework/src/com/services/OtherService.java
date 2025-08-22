package com.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.dto.TrajetViewDto;
import com.models.Avion;
import com.repositories.OtherRepo;

public class OtherService extends Service
{
    private EntityManagerFactory emf = this.getEntityManagerFact();

    public List<Avion> getAllAvions() throws Exception {
        EntityManager em = emf.createEntityManager();
        OtherRepo repo = new OtherRepo(em);
        List<Avion> avions = null;

        try {
            avions = repo.getAllAvions();
        } catch(Exception e) {
            throw new Exception("Impossible d'obtenir les avions pour le moment !");
        } finally { em.close(); }

        return avions;
    }


    public List<TrajetViewDto> getAllTrajects() throws Exception {
        EntityManager em = emf.createEntityManager();
        OtherRepo repo = new OtherRepo(em);
        List<TrajetViewDto> trajets = null;

        try {
            trajets = repo.getAllTrajects();
        } catch(Exception e) {
            throw new Exception("Impossible d'obtenir les trajets pour le moment !"+e.getMessage());
        } finally { em.close(); }

        return trajets;
    }
}
