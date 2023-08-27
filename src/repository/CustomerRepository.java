package repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Util.sessionFactoryConfiguration;
import entity.CustomerEntity;
import entity.OrderEntity;

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

    // order by

    public List<CustomerEntity> getAllCustomersOrderByNameDesc() {
        String hql = "FROM CustomerEntity ORDER BY name DESC";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;
    }

    // SELECT Count(CustID), SUM(salary), AVG(salary), MAX(salary), MIN(salary) FROM
    // Customer;

    public Object[] getCustomerSummery() {
        String hql = "SELECT count(id), sum(salary), avg(salary), max(salary), min(salary) FROM CustomerEntity";
        Query query = session.createQuery(hql);
        Object[] data = (Object[]) query.uniqueResult();
        return data;
    }

    // SELECT province, Count(CustID), SUM(salary), AVG(salary), MAX(salary),
    // MIN(salary) FROM Customer GROUP BY province;

    public List<Object[]> getCustomerSummeryByProvince() {
        String hql = "SELECT province ,count(id), sum(salary), avg(salary), max(salary), min(salary) FROM CustomerEntity GROUP BY province";
        Query query = session.createQuery(hql);
        List<Object[]> data = query.list();
        return data;
    }

    public List<OrderEntity> getOrdersBeforeAndProvince(Date date, String province) {
        String hql = "SELECT ord FROM CustomerEntity AS cust INNER JOIN cust.orderEntities AS ord WHERE cust.province =:province AND ord.date<:date";
        Query query = session.createQuery(hql);
        query.setParameter("province", province);
        query.setParameter("date", date);

        List<OrderEntity> orderEntities = query.list();
        return orderEntities;
    }

}
