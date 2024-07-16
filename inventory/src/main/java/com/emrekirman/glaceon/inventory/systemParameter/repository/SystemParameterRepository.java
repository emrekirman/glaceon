package com.emrekirman.glaceon.inventory.systemParameter.repository;

import com.emrekirman.glaceon.inventory.systemParameter.entity.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemParameterRepository extends JpaRepository<SystemParameter, Integer> {

    Optional<SystemParameter> findByCode(String code);
}
