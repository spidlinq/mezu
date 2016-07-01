package com.spidlinq.mezu;

import com.spidlinq.mezu.demo.DemoEvent;
import com.spidlinq.mezu.demo.DemoHandler;
import com.spidlinq.mezu.exception.EventDispatchException;
import com.spidlinq.mezu.exception.EventRegistrationException;
import com.spidlinq.mezu.exception.NoValidHandlerException;
import com.spidlinq.mezu.generic.EbentDispatcher;

/**
 * Created by .local on 01/07/2016.
 */
public class Demo {

    public static void main(String[] args) {
        EbentDispatcher dispatcher = new EbentDispatcher();
        try {
            dispatcher.registerEventHandler(DemoEvent.class, new DemoHandler());
            dispatcher.dispatch(new DemoEvent("Hello World!"));
        } catch (EventRegistrationException | NoValidHandlerException | EventDispatchException e) {
            System.err.println(e.getMessage());
        }
    }
}
