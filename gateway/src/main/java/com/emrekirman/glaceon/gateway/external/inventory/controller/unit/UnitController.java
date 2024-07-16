package com.emrekirman.glaceon.gateway.external.inventory.controller.unit;

import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitUpdateRequest;
import com.emrekirman.glaceon.gateway.external.inventory.service.unit.IUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/units")
@RequiredArgsConstructor
public class UnitController {
    private final IUnitService unitService;

    @PostMapping
    public ResponseEntity<UnitResponse> create(@RequestBody UnitRequest unitRequest) {
        return ResponseEntity.ok(unitService.create(unitRequest));
    }

    @PutMapping
    public ResponseEntity<UnitResponse> update(@RequestBody UnitUpdateRequest unitUpdateRequest) {
        return ResponseEntity.ok(unitService.update(unitUpdateRequest));
    }

    @GetMapping
    public ResponseEntity<List<UnitResponse>> findAll() {
        return ResponseEntity.ok(unitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(unitService.findById(id));
    }
}
