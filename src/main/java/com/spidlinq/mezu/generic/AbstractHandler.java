package com.spidlinq.mezu.generic;

import com.spidlinq.mezu.base.EbentChannel;

/**
 * Created by .local on 01/07/2016.
 */
public abstract class AbstractHandler implements EbentChannel<AbstractEvent> {

    private static final boolean EVENT_DISPATCHED = true;
    private static final boolean EVENT_NOT_DISPATCHED = false;

    @Override
    public boolean onDispatchHandler(AbstractEvent message) {
        if (message != null) {
            dispatch(message);
            return EVENT_DISPATCHED;
        }
        System.err.println("Received message is not valid");
        return EVENT_NOT_DISPATCHED;
    }

    public abstract void dispatch(AbstractEvent message);
}
