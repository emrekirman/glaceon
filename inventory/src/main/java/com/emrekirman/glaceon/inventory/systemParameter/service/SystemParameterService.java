package com.emrekirman.glaceon.inventory.systemParameter.service;

import com.emrekirman.glaceon.inventory.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.inventory.systemParameter.repository.SystemParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemParameterService {
    private final SystemParameterRepository systemParameterRepository;


    public String getValueByCode(String code) {
        return systemParameterRepository
                .findByCode(code)
                .orElseThrow(()->new CustomNotFoundException("system.parameter.not.found"))
                .getValue();
    }
}
