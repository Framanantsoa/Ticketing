package com.repositories;

import javax.persistence.EntityManager;

public class Repository 
{
    private EntityManager em;

    public Repository(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }
}
