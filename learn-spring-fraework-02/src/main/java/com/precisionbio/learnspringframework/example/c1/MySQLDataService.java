package com.precisionbio.learnspringframework.example.c1;

import org.springframework.stereotype.Component;

/**
 * Component 어노테이션으로 Spring Bean 등록
 */
@Component
public class MySQLDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }

}
