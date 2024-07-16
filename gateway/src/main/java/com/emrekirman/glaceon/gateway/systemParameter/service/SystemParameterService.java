package com.emrekirman.glaceon.gateway.systemParameter.service;

import com.emrekirman.glaceon.gateway.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.gateway.systemParameter.repository.SystemParameterRepository;
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
