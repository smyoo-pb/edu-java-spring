package com.precisionbio.learnspringframework.example.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

/**
 * Component 어노테이션으로 Spring Bean 등록
 */
@Component
public class BusinessCalculationService {
    private DataService dataService;

    /**
     * 생성자 주입
     * 
     * @param dataService
     */
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);

    }
}
