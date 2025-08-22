package com.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Service 
{
    private EntityManagerFactory emf;
    
    public Service() {
        this.emf = Persistence.createEntityManagerFactory("Ticketing");
    }

    public EntityManagerFactory getEntityManagerFact() {
        return this.emf;
    }
}
