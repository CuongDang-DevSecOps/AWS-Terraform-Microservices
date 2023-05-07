package com.example.appointmentorchestrator.auths.repositories;

import com.example.appointmentorchestrator.auths.entities.Role;
import com.example.appointmentorchestrator.auths.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleType name);
}
