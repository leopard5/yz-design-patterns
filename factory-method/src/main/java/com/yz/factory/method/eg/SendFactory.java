package com.yz.factory.method.eg;

public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {

        // simple factory
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();

        // static factory
        Sender senderTest = SendFactory.produceMail();
        senderTest.Send();
    }

}
