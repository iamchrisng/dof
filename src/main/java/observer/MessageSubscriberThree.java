package observer;

import observer.model.Message;

public class MessageSubscriberThree implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("MessageSubscriberThree :: " + message.getMessageContent());
    }
}
