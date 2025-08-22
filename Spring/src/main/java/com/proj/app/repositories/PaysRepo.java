package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Pays;

@Repository
public interface PaysRepo extends JpaRepository<Pays, Long>
{
    
}
