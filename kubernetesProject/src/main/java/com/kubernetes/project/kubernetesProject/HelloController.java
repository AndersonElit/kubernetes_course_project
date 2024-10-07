package com.kubernetes.project.kubernetesProject;

import com.kubernetes.project.kubernetesProject.entity.Customer;
import com.kubernetes.project.kubernetesProject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CustomerRepository customerRepository;

    @PostMapping("/save")
    public String save(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer.toString();
    }

    @GetMapping("/list")
    public String getList() {
        return customerRepository.findAll().toString();
    }

}
