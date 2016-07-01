package com.spidlinq.mezu.base;

/**
 * Created by .local on 01/07/2016.
 */
public interface EbentMessage {

    Class<? extends EbentMessage> getType();
}
