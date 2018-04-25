package com.yz.factory.method.eg;

public class SenderFactory extends AbstractSenderFactory {
    @Override
    public <T extends Sender> T createSender(Class<T> c) {
        Sender sender = null;
        try {
            sender = (Sender) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("Error!!!");
        }
        return (T) sender;
    }
}
