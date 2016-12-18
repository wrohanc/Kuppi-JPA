package com.ro.learn.businesslogic;

import com.ro.learn.model.Customer;
import com.ro.learn.util.Constants;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rohan on 2016-12-18.
 */
@Stateless
@LocalBean
public class CustomerManagerBean {
    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    protected EntityManager em;

    public Customer registerCustomer(Customer customer) {//can get from api

        customer.setMerchantCode(System.currentTimeMillis());//custom generated PK
        customer.getAccount().setCustomer(customer);//link

        em.persist(customer);

        return customer;

    }

    public Customer updateCustomer(Customer customer) {//can get from api
        //either directly merge or update old one
        //Customer old = em.find(Customer.class, customer.getMerchantCode());

        //customer.getAccount().setCustomer(customer);//link

        em.merge(customer);
        //em.merge(old);

        return customer;

    }

    public Customer login(String loginName, String password) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByLoginName", Customer.class);
        query.setParameter("loginName", loginName);
        List<Customer> customers = query.getResultList();
        if (customers.size() < 1) {
            return null;
        }

        Customer customer = customers.get(0);//todo assume only one record
        if (!password.equalsIgnoreCase(customer.getPassword())) {
            customer.setNoOfFailedLogins(customer.getNoOfFailedLogins() + 1);
            em.merge(customer);

            return null;
        }

        return customer;

    }
}
