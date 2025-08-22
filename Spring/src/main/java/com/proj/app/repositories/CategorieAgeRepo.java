package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.CategorieAge;

@Repository
public interface CategorieAgeRepo extends JpaRepository<CategorieAge, Long>
{
    
}
