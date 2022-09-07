package com.piyush.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBean2Filter")
public class SomeBean2 {
    private String field4;

    private String field5;

    private String field6;

    public SomeBean2(String field4, String field5, String field6) {
        super();
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
    }

    public String getfield4() {
        return field4;
    }

    public String getfield5() {
        return field5;
    }

    public String getfield6() {
        return field6;
    }

    @Override
    public String toString() {
        return "SomeBean [field4=" + field4 + ", field5=" + field5 + ", field6=" + field6 + "]";
    }
}
