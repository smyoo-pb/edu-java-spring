package com.precisionbio.learnspringframework.example.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Component 어노테이션으로 Spring Bean 등록
 */
// @Component
@Repository
public class MySQLDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }

}
