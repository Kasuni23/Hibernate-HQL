import java.util.List;

import entity.CustomerEntity;
import repository.CustomerRepository;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerRepository repository = new CustomerRepository();

        List<CustomerEntity> customerEntities = repository.getALLCustomer();
        customerEntities.forEach(e -> {
            System.out.println(e);
        });
    }
}
