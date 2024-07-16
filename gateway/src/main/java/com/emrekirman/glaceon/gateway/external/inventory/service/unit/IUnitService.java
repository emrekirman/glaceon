package com.emrekirman.glaceon.gateway.external.inventory.service.unit;

import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitUpdateRequest;

import java.util.List;

public interface IUnitService {
    UnitResponse create(UnitRequest unitRequest);

    UnitResponse update(UnitUpdateRequest unitRequest);

    List<UnitResponse> findAll();

    UnitResponse findById(Integer id);
}
