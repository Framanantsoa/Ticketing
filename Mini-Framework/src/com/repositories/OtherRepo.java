package com.repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.dto.TrajetViewDto;
import com.models.Avion;

public class OtherRepo extends Repository
{
    public OtherRepo(EntityManager em) {
        super(em);
    }

    public List<Avion> getAllAvions() throws Exception {
        String sql = "SELECT a FROM Avion a";
    
        return getEntityManager()
         .createQuery(sql, Avion.class).getResultList();
    }


    public List<TrajetViewDto> getAllTrajects() {
        String sql = "SELECT "
            +"t.*, f.frais_adulte, f.frais_enfant, f.frais_business "
            +"FROM v_trajets t "
            +"JOIN v_frais f ON t.id_trajet=f.id_trajet";

        List<Object[]> rows = getEntityManager()
            .createNativeQuery(sql)
            .getResultList();

        List<TrajetViewDto> result = new ArrayList<>();
        for (Object[] row : rows) {
            result.add(new TrajetViewDto(
                ((Number) row[0]).longValue(),
                (String) row[1],
                (String) row[2],
                (String) row[3],
                (String) row[4],
                ((Number) row[5]).doubleValue(),
                ((Number) row[6]).doubleValue(),
                ((Number) row[7]).doubleValue()
            ));
        }
        return result;
    }

    
}
