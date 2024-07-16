package com.emrekirman.glaceon.inventory.unit.mapper;

import com.emrekirman.glaceon.inventory.common.mapper.IBaseMapper;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import com.emrekirman.glaceon.inventory.unit.model.UnitRequest;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UnitMapper extends IBaseMapper<UnitRequest, UnitResponse, Unit> {

    @Mapping(target = "id", source = "unitUpdateRequest.id")
    @Mapping(target = "createdDate", source = "unit.createdDate")
    @Mapping(target = "createdUser", source = "unit.createdUser")
    @Mapping(target = "name", source = "unitUpdateRequest.name")
    @Mapping(target = "code", source = "unitUpdateRequest.code")
    Unit mapUpdateToEntity(UnitUpdateRequest unitUpdateRequest, Unit unit);
}
