package com.precisionbio.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * FilteringController
 *
 * @author smyoo-pb
 * @date 2023/08/26
 */
@RestController
public class FilteringController {

    private FilterProvider makeFilter(String id, String... fields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter(id, filter);
        return filters;
    }

    private MappingJacksonValue makeJacksonValue(Object obj, FilterProvider filters) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(obj);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean somBean = new SomeBean("value1", "value2", "value3");
        return makeJacksonValue(
                somBean,
                makeFilter("SomeBeanFilter", "field1", "field3"));
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        return makeJacksonValue(
                list,
                makeFilter("SomeBeanFilter", "field1", "field2"));

    }
}
