package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Util.sessionFactoryConfiguration;
import entity.CustomerEntity;

public class CustomerRepository {
    Session session = sessionFactoryConfiguration.getInstance().getSession();

    public CustomerEntity getCustomer(String id) {

        CustomerEntity customerEntity = session.get(CustomerEntity.class, id);
        return customerEntity;
    }

    // hql query
    public List<CustomerEntity> getALLCustomer() {
        String hql = "FROM CustomerEntity";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;
    }

    // native query query
    public List<Object[]> getALLCustomerByNative() {
        String sql = "select * from customer;";
        Query query = session.createSQLQuery(sql);
        List<Object[]> data = query.list();
        return data;
    }

    // get specific coloumn using hql
    public List<Object[]> getALLCustomerNameAndDOB() {
        String hql = "SELECT C.id, C.name, C.dob FROM CustomerEntity C";
        Query query = session.createQuery(hql);
        List<Object[]> data = query.list();
        return data;
    }

    // using where clause in hql
    public CustomerEntity getCustomerByHQL(String custId) {
        String hql = "FROM CustomerEntity WHERE id= '" + custId + "'";
        Query query = session.createQuery(hql);
        CustomerEntity customerEntity = (CustomerEntity) query.uniqueResult(); // to get one result from database
        return customerEntity;
    }

    public CustomerEntity getCustomerByHQLUsingNamedParameterd(String custId) {
        String hql = "FROM CustomerEntity WHERE id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", custId);
        CustomerEntity customerEntity = (CustomerEntity) query.uniqueResult();
        return customerEntity;
    }

}
