package com.precisionbio.learnspringframework.example.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Component 어노테이션으로 Spring Bean 등록
 * Primary 어노테이션으로 우선순위 설정
 */
@Component
@Primary
public class MongoDbDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] { 11, 22, 33, 44, 55 };
    }
}
