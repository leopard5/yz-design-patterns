package com.yz.factory.method.eg;

public abstract class AbstractSenderFactory {

    public abstract <T extends Sender>T createSender(Class<T> c);
}
