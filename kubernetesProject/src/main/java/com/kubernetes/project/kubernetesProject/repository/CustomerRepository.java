package com.kubernetes.project.kubernetesProject.repository;

import com.kubernetes.project.kubernetesProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
