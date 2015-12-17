package com.simdevmon.redeployment;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Simon Narkprasert
 */
@Stateless
public class ExampleService
{
    @PersistenceContext
    EntityManager em;

    public List<ExampleEntity> getExamples()
    {
        return em.createNamedQuery(ExampleEntity.ALL, ExampleEntity.class).getResultList();
    }
}
