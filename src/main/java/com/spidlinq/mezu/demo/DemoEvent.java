package com.spidlinq.mezu.demo;

import com.spidlinq.mezu.generic.AbstractEvent;

/**
 * Created by .local on 01/07/2016.
 */
public class DemoEvent extends AbstractEvent {

    private String name;

    public DemoEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
