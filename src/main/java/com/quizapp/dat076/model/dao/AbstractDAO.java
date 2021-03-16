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
 * A DAO that provides general useful methods for the handling and retrieving of
 * data from the database.
 *
 * @author Albin
 * @author Anton Ekman
 * @author Anton Blomdell
 * @author Emma
 * @author Rebecka
 */
@RequiredArgsConstructor
public abstract class AbstractDAO<K, T> {

    private final Class<T> entityType;

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);

    }

    public T find(K key) {

        return getEntityManager().find(entityType, key);

    }

    public int size() {
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

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }
}
