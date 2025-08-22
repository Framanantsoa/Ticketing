package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.ConfigFrais;

@Repository
public interface ConfigFraisRepo extends JpaRepository<ConfigFrais, Long> 
{
    
}
