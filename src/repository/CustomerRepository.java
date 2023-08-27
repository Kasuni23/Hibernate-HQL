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

    public List<CustomerEntity> getALLCustomer() {
        String hql = "FROM CustomerEntity";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;
    }

}
