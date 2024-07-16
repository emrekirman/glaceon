package com.emrekirman.glaceon.inventory.unit;

import com.emrekirman.glaceon.inventory.common.security.CustomUserDetails;
import com.emrekirman.glaceon.inventory.common.security.SessionInformation;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import com.emrekirman.glaceon.inventory.unit.mapper.UnitMapper;
import com.emrekirman.glaceon.inventory.unit.model.UnitRequest;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitUpdateRequest;
import com.emrekirman.glaceon.inventory.unit.repository.UnitRepository;
import com.emrekirman.glaceon.inventory.unit.service.IUnitService;
import com.emrekirman.glaceon.inventory.unit.service.impl.UnitCheckMandaService;
import com.emrekirman.glaceon.inventory.unit.service.impl.UnitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UnitMockTests {

    @Mock
    UnitRepository unitRepository;

    @Mock
    UnitMapper unitMapper;

    @Mock
    UnitCheckMandaService unitCheckMandaService;


    IUnitService unitService;

    @BeforeEach
    void setUp() {
        unitService = new UnitService(unitRepository, unitMapper, unitCheckMandaService);

        Mockito.mockStatic(SessionInformation.class);

        Mockito.when(SessionInformation.getUser())
                .thenReturn(new CustomUserDetails());
    }


    @Test
    void create() {
        UnitRequest unitRequest = new UnitRequest();
        unitRequest.setName("test name");

        Unit unit = new Unit();
        unit.setName(unitRequest.getName());

        Mockito.doNothing()
                .when(unitCheckMandaService)
                .createCheckManda(Mockito.any());

        Mockito.when(unitMapper.mapRequestToEntity(unitRequest))
                .thenReturn(unit);

        unit.setId(1);
        unit.setCreatedDate(new Date());

        Mockito.when(unitRepository.save(unit))
                .thenReturn(unit);

        UnitResponse unitResponse = new UnitResponse();
        unitResponse.setName(unit.getName());
        unitResponse.setCode(unit.getCode());

        Mockito.when(unitMapper.mapEntityToResponse(Mockito.any()))
                .thenReturn(unitResponse);

        UnitResponse response = unitService.create(unitRequest);

        System.out.println("response : " + response.getName());

    }

    @Test
    void update() {
        UnitUpdateRequest unitUpdateRequest = new UnitUpdateRequest();
        unitUpdateRequest.setId(2);
        unitUpdateRequest.setName("test name");

        Unit unit = new Unit();
        unit.setName("test name");

        Mockito.when(unitRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(unit));

        Mockito.when(unitMapper.mapUpdateToEntity(Mockito.any(), Mockito.any()))
                .thenReturn(unit);

        Mockito.doNothing()
                .when(unitCheckMandaService)
                .updateCheckManda(Mockito.any(), Mockito.any());

        Mockito.when(unitMapper.mapEntityToResponse(Mockito.any()))
                .thenReturn(new UnitResponse());

        unitService.update(unitUpdateRequest);
    }


}
