package com.spidlinq.mezu.demo;

import com.spidlinq.mezu.generic.AbstractEvent;
import com.spidlinq.mezu.generic.AbstractHandler;

/**
 * Created by .local on 01/07/2016.
 */
public class DemoHandler extends AbstractHandler {

    @Override
    public void dispatch(AbstractEvent message) {
        DemoEvent demoEvent = (DemoEvent) message;
        System.out.println("This message says: " + demoEvent.getName());
        System.out.println("Demo event successfully dispatched!");
    }
}
