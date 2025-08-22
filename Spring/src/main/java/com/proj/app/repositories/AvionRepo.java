package com.proj.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proj.app.entities.Avion;

@Repository
public interface AvionRepo extends JpaRepository<Avion, Long>{}
