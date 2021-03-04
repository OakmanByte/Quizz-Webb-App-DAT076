/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Albin
 */
@RequiredArgsConstructor
public abstract class AbstractDAO<K, T> {

    private final Class<T> entityType;

    protected abstract EntityManager getEntityManager();

    /* public long count() {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery cq = builder.createQuery();
        final Root<T> rt = cq.from(entityType);

        cq.select(builder.count(rt));

        final Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult());
    }*/
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T find(K key) {

        return getEntityManager().find(entityType, key);

    }

    public int countTest() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = builder.createQuery(Long.class);
        Root<T> root = cq.from(entityType);
        cq.select(builder.count(root));
        Long count = getEntityManager().createQuery(cq).getSingleResult();
        return count.intValue();
    }

    public List<T> findAll() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(entityType);
        cq.from(entityType);
        TypedQuery<T> query = getEntityManager().createQuery((cq));
        return query.getResultList();
    }

    public T getFirst() {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityType));
        return (T) getEntityManager().createQuery(cq).getSingleResult();
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }
}
