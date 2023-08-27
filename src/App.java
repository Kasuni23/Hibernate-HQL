import java.util.Arrays;
import java.util.List;

import entity.CustomerEntity;
import repository.CustomerRepository;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerRepository repository = new CustomerRepository();

        // List<CustomerEntity> customerEntities = repository.getALLCustomer();
        // customerEntities.forEach(e -> {
        // System.out.println(e);
        // });

        // List<Object[]> data = repository.getALLCustomerByNative();
        // data.forEach(e -> {
        // System.out.println(Arrays.toString(e));
        // });

        // List<Object[]> data = repository.getALLCustomerNameAndDOB();
        // data.forEach(e -> {
        // System.out.println(Arrays.toString(e));
        // });

        // CustomerEntity c1 = repository.getCustomerByHQL("C005");
        // System.out.println(c1.toString());

        CustomerEntity c1 = repository.getCustomerByHQLUsingNamedParameterd("C005");
        System.out.println(c1.toString());

    }
}
