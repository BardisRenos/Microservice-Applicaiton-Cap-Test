package com.example.mapper;

import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * The dto mapper. The class that does the conversion from Customer object into CustomerDTO and CustomerTransactionDTO objects
 */
@Service
public class CustomerMapper {

    /**
     * The conversion of the Customer object into CustomerTransactionDTO
     * @param customer customer class
     * @return CustomerTransactionDTO class
     */
//    public static CustomerTransactionDTO toCustomerTransactionDTO(Customer customer) {
//        return new ModelMapper().map(customer, CustomerTransactionDTO.class);
//    }

    /**
     * The conversion of the Customer object into CustomerDTO
     * @param customer customer class
     * @return CustomerDTO class
     */
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new ModelMapper().map(customer, CustomerDTO.class);
    }
}
