package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Statut;

@Repository
public interface StatutRepo  extends JpaRepository<Statut, Long>
{
    
}
