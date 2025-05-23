package com.hamed.ecommerce.customer;


import com.hamed.ecommerce.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {

        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();

    }

    public void updatedCustomer(CustomerRequest request) {

        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(format("Can not update customer:: Customer can not be found with the provided ID:: %s", request.id())));

        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {

        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setLastname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if(request.address() != null){
            customer.setAddress(request.address());
        }
    }


    public List<CustomerResponse> findAllCustomers() {
        var customers = repository.findAll();

        return customers
                .stream()
                .map(mapper:: toCustomerResponse)
                .collect(Collectors.toList());
    }

    public Boolean existById(String customerId) {

        return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findCustomerById(String customerId) {

        var customer = repository.findById(customerId);
        return customer
                .map(mapper:: toCustomerResponse)
                .orElseThrow(()-> new CustomerNotFoundException(format("Customer not found with the provided ID:: %s", customerId)));
    }


    public void deleteCustomer(String customerId) {

        repository.deleteById(customerId);

    }
}





