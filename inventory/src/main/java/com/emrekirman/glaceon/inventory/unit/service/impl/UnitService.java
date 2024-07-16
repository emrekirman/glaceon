package com.emrekirman.glaceon.inventory.unit.service.impl;

import com.emrekirman.glaceon.inventory.common.entity.BaseDefinitionEntity;
import com.emrekirman.glaceon.inventory.common.entity.BaseEntity;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import com.emrekirman.glaceon.inventory.unit.mapper.UnitMapper;
import com.emrekirman.glaceon.inventory.unit.model.UnitRequest;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitUpdateRequest;
import com.emrekirman.glaceon.inventory.unit.repository.UnitRepository;
import com.emrekirman.glaceon.inventory.unit.service.IUnitApi;
import com.emrekirman.glaceon.inventory.unit.service.IUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService implements IUnitService, IUnitApi {
    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;
    private final UnitCheckMandaService unitCheckMandaService;

    @Override
    public UnitResponse create(UnitRequest unitRequest) {
        Unit unit = unitMapper.mapRequestToEntity(unitRequest);

        BaseEntity.setCreateAudit(unit);
        BaseDefinitionEntity.prepareCode(unit);

        unitCheckMandaService.createCheckManda(unit);

        Unit saved = unitRepository.save(unit);

        return unitMapper.mapEntityToResponse(saved);
    }

    @Override
    public UnitResponse update(UnitUpdateRequest unitUpdateRequest) {
        Unit oldUnit = unitRepository
                .findById(unitUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("unit.not.found"));

        Unit unit = unitMapper.mapUpdateToEntity(unitUpdateRequest, oldUnit);

        BaseEntity.setUpdateAudit(unit);
        BaseDefinitionEntity.prepareCode(unit);

        unitCheckMandaService.updateCheckManda(unit, oldUnit);

        Unit saved = unitRepository.save(unit);

        return unitMapper.mapEntityToResponse(saved);
    }

    @Override
    public List<UnitResponse> findAll() {
        List<Unit> all = unitRepository.findAll();

        return unitMapper.mapEntityToResponseList(all);
    }

    @Override
    public UnitResponse findById(Integer id) {
        Unit unit = unitRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("unit.not.found"));

        return unitMapper.mapEntityToResponse(unit);
    }

    @Override
    public Unit getById(Integer id) {
        return unitRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("unit.not.found"));
    }
}
