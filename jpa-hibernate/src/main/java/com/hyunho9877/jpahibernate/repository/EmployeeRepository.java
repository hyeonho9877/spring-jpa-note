package com.hyunho9877.jpahibernate.repository;


import com.hyunho9877.jpahibernate.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager em;

    //insert
    public void insert(Employee employee) {
        em.persist(employee);
    }

    //retrieve all employees;

    public List<Employee> findAllPartTime() {
        return em.createQuery("select p from PartTimeEmployee p", Employee.class).getResultList();
    }

    public List<Employee> findAllFullTime() {
        return em.createQuery("select f from FullTimeEmployee f", Employee.class).getResultList();
    }
}
