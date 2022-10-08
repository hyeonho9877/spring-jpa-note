package com.hyunho9877.springjpanote.jpa;

import com.hyunho9877.springjpanote.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public Person update(Person person) {
        return em.merge(person);
    }

    public Person insert(Person person) {
        return em.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        em.remove(person);
    }

    public List<Person> findAll() {
        TypedQuery<Person> nameQuery = em.createNamedQuery("find_all_persons", Person.class);
        return nameQuery.getResultList();
    }
}
