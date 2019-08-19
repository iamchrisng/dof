package observer;

import observer.model.Message;

public class MessageSubscriberTwo implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("MessageSubscriberTwo :: " + message.getMessageContent());
    }
}
