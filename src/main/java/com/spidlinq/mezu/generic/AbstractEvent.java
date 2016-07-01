package com.spidlinq.mezu.generic;

import com.spidlinq.mezu.base.EbentMessage;

/**
 * Created by .local on 01/07/2016.
 */
public abstract class AbstractEvent implements EbentMessage {

    @Override
    public Class<? extends EbentMessage> getType() {
        return getClass();
    }
}
