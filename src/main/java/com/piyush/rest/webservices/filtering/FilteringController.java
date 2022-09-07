package com.piyush.rest.webservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    /*STATIC FILTERING*/
    @GetMapping("/filtering-static")
    public SomeBean filteringStatic() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return someBean;
    }

    @GetMapping("/filtering-static-list")
    public List<SomeBean> filteringStaticList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        return list;
    }

    /*DYNAMIC FILTERING*/
    @GetMapping("/filtering") //field2
    public MappingJacksonValue filtering() {

        SomeBean2 someBean = new SomeBean2("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field4", "field5");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBean2Filter", filter);

        mappingJacksonValue.setFilters(filters);


        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list") //field2, field3
    public MappingJacksonValue filteringList() {
        List<SomeBean2> list = Arrays.asList(new SomeBean2("value1", "value2", "value3"),
                new SomeBean2("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field4", "field6");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBean2Filter", filter);

        mappingJacksonValue.setFilters(filters);


        return mappingJacksonValue;
    }

}