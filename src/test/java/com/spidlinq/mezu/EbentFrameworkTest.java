package com.spidlinq.mezu;

import com.spidlinq.mezu.demo.DemoEvent;
import com.spidlinq.mezu.demo.DemoHandler;
import com.spidlinq.mezu.generic.EbentDispatcher;
import org.junit.Assert;

/**
 * Created by .local on 01/07/2016.
 */
public class EbentFrameworkTest {

    @org.junit.Test
    public void dispatch() throws Exception {
        EbentDispatcher dispatcher = new EbentDispatcher();
        dispatcher.registerEventHandler(DemoEvent.class, new DemoHandler());
        boolean dispatched = dispatcher.dispatch(new DemoEvent("Hello World!"));
        Assert.assertEquals(dispatched, EbentDispatcher.SUCCESSFUL_DISPATCHED);
    }

}