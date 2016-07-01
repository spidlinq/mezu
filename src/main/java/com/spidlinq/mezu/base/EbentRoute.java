package com.spidlinq.mezu.base;

import com.spidlinq.mezu.exception.EventDispatchException;
import com.spidlinq.mezu.exception.EventRegistrationException;
import com.spidlinq.mezu.exception.NoValidHandlerException;

/**
 * Created by .local on 01/07/2016.
 */
public interface EbentRoute<E extends EbentMessage> {

    boolean registerEventHandler(Class<? extends E> contentType, EbentChannel<? extends E> channel) throws EventRegistrationException;

    boolean dispatch(E content) throws NoValidHandlerException, EventDispatchException;
}
