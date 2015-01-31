package se.rosscom.timereader.test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import static se.rosscom.timereader.test.UnitTestInMemoryPersistenceProperties.getInMemoryPersistenceProperties;

public class InMemoryPersistence implements AutoCloseable {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public InMemoryPersistence() throws Exception {

        // Mute hbm2ddl...
        Logger.getLogger("org.hibernate.tool.hbm2ddl").setLevel(Level.FATAL);

        Properties override = getInMemoryPersistenceProperties();

        entityManagerFactory = Persistence.createEntityManagerFactory(TimeReaderPersistenceUnit.PERSISTENCE_UNIT_NAME_TEST, override);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() throws Exception {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    private void reset() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.clear();
            entityManager.close();
        }
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager resetForTest() {
        reset();
        return entityManager;
    }

    public EntityManager resetForVerification() {
        reset();
        return entityManager;
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    public <T> List<T> findByNamedQuery(Class<T> entityClass, String namedQuery, Map<String, ?> parameters) {
        TypedQuery<T> typedQuery = entityManager.createNamedQuery(namedQuery, entityClass);
        for(Map.Entry<String, ?> parameter : parameters.entrySet()) {
            typedQuery.setParameter(parameter.getKey(), parameter.getValue());
        }
        return typedQuery.getResultList();
    }

    public <T> T getSingleByNamedQuery(Class<T> entityClass, String namedQuery, Map<String, ?> parameters) {
        TypedQuery<T> typedQuery = entityManager.createNamedQuery(namedQuery, entityClass);
        for(Map.Entry<String, ?> parameter : parameters.entrySet()) {
            typedQuery.setParameter(parameter.getKey(), parameter.getValue());
        }
        return typedQuery.getSingleResult();
    }

    public Tx beginTx() {
        return new Tx();
    }

    public class Tx implements AutoCloseable {
        private EntityTransaction tx;
        private boolean committed = false;

        public Tx() {
            tx = InMemoryPersistence.this.entityManager.getTransaction();
            tx.begin();
        }

        public <T> T persist(T entity) {
            entityManager.persist(entity);
            return entity;
        }

        public void remove(Object entity) {
            entityManager.remove(entity);
        }

        public <T> T find(Class<T> entityClass, Object primaryKey) {
            return InMemoryPersistence.this.find(entityClass, primaryKey);
        }

        public void commit() {
            tx.commit();
            committed = true;
        }

        @Override
        public void close() throws Exception {
            if (tx.isActive()) {
                if (!committed && !tx.getRollbackOnly()) {
                    tx.commit();
                } else {
                    tx.rollback();
                }
            }
        }
    }
}
