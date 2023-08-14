package com.precisionbio.learnspringframework.example.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Component 어노테이션으로 Spring Bean 등록
 */
// @Component

/**
 * Service 비스니스 로직을 작성한 클래스라는 것을 명시
 */
@Service
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
