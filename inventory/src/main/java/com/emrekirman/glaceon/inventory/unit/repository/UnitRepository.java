package com.emrekirman.glaceon.inventory.unit.repository;

import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    boolean existsByCode(String code);

    boolean existsByCodeAndIdNot(String code, Integer id);
}
