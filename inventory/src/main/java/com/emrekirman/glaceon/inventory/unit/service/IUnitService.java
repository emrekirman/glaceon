package com.emrekirman.glaceon.inventory.unit.service;

import com.emrekirman.glaceon.inventory.unit.model.UnitRequest;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitUpdateRequest;

import java.util.List;

public interface IUnitService {
    UnitResponse create(UnitRequest unitRequest);

    UnitResponse update(UnitUpdateRequest unitUpdateRequest);

    List<UnitResponse> findAll();

    UnitResponse findById(Integer id);
}
