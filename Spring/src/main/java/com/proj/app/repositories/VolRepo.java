package com.proj.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Vol;

@Repository
public interface VolRepo extends JpaRepository<Vol, Long>
{
// CRUD VOL
    @Query(value="SELECT * FROM vols WHERE is_deleted=false", nativeQuery=true)
    public List<Vol> findAllFlights();


    @Query(value="SELECT * FROM vols WHERE id_vol=:id AND"
    +" is_deleted=false LIMIT 1", nativeQuery=true)
    public Vol findFlightById(@Param("id") Long id);
}
