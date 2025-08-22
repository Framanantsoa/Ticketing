package com.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.models.Vol;
import com.repositories.VolRepository;

public class VolService extends Service
{
    private EntityManagerFactory emf = this.getEntityManagerFact();

    public List<Vol> getAllVols() {
        EntityManager em = emf.createEntityManager();
        VolRepository volRepo = new VolRepository(em);

        List<Vol> vols = volRepo.getAllVols();
        em.close();
        return vols;
    }

    public Vol getVolById(Long id) {
        EntityManager em = emf.createEntityManager();
        VolRepository volRepo = new VolRepository(em);

        em.close();
        return volRepo.getVolById(id);
    }


    public int getPlacesEcoDispo(Long idVol) {
        EntityManager em = emf.createEntityManager();
        VolRepository volRepo = new VolRepository(em);

        int placesDispo = volRepo.getSiegeEcoLibre(idVol);
        em.close();
        return placesDispo;
    }

    public int getPlacesBusDispo(Long idVol) {
        EntityManager em = emf.createEntityManager();
        VolRepository volRepo = new VolRepository(em);

        int placesDispo = volRepo.getSiegeBusLibre(idVol);
        em.close();
        return placesDispo;
    }
}
