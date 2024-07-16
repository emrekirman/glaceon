package com.emrekirman.glaceon.inventory.unit.controller;

import com.emrekirman.glaceon.inventory.unit.model.UnitRequest;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitUpdateRequest;
import com.emrekirman.glaceon.inventory.unit.service.IUnitService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UnitResponse> create(@Valid @RequestBody UnitRequest unitRequest) {
        UnitResponse unitResponse = unitService.create(unitRequest);

        return ResponseEntity.ok(unitResponse);
    }

    @PutMapping
    public ResponseEntity<UnitResponse> update(@Valid @RequestBody UnitUpdateRequest unitUpdateRequest) {

        UnitResponse update = unitService.update(unitUpdateRequest);

        return ResponseEntity.ok(update);
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
