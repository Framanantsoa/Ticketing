package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Trajet;

@Repository
public interface TrajetRepo extends JpaRepository<Trajet, Long>
{
    
}
