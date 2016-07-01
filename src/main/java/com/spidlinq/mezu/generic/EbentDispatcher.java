package com.spidlinq.mezu.generic;

import com.spidlinq.mezu.base.EbentChannel;
import com.spidlinq.mezu.base.EbentRoute;
import com.spidlinq.mezu.exception.EventDispatchException;
import com.spidlinq.mezu.exception.EventRegistrationException;
import com.spidlinq.mezu.exception.NoValidHandlerException;

import java.util.HashMap;

/**
 * Created by .local on 01/07/2016.
 */
public final class EbentDispatcher implements EbentRoute<AbstractEvent> {

    public static final boolean SUCCESFUL_REGISTERED = true;
    public static final boolean SUCCESSFUL_DISPATCHED = true;

    private final HashMap<Class<? extends AbstractEvent>, AbstractHandler> handlers;

    public EbentDispatcher() {
        handlers = new HashMap<>();
    }

    @Override
    public boolean registerEventHandler(Class<? extends AbstractEvent> contentType,
                                        EbentChannel<? extends AbstractEvent> channel) throws EventRegistrationException {
        if (handlers != null && channel != null && contentType != null && channel instanceof AbstractHandler) {
            handlers.put(contentType, (AbstractHandler) channel);
            return SUCCESFUL_REGISTERED;
        }
        throw new EventRegistrationException("Current event registration parameters are not valid.");
    }

    @Override
    public boolean dispatch(AbstractEvent content) throws NoValidHandlerException, EventDispatchException {
        if (handlers != null && content != null) {
            Class<? extends AbstractEvent> eventClass = content.getClass();
            AbstractHandler handler = handlers.get(eventClass);
            if (handler != null) {
                handler.onDispatchHandler(content);
                return SUCCESSFUL_DISPATCHED;
            }
            throw new NoValidHandlerException("There are no available handlers for this type of event (" + eventClass.getName() + ")");
        }
        throw new EventDispatchException("Current event dispatch parameters are not valid.");
    }
}

