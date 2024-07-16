package com.emrekirman.glaceon.inventory.unit.service.impl;

import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import com.emrekirman.glaceon.inventory.unit.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitCheckMandaService {
    private final UnitRepository unitRepository;

    public void createCheckManda(Unit unit) {
        if (unitRepository.existsByCode(unit.getCode())) {
            throw new CustomRuntimeException("unit.already.added");
        }
    }

    public void updateCheckManda(Unit unit, Unit oldUnit) {
        if (!oldUnit.getCode().equals(unit.getCode())) {
            if (unitRepository.existsByCodeAndIdNot(unit.getCode(), unit.getId())) {
                throw new CustomRuntimeException("unit.already.added");
            }
        }
    }
}
