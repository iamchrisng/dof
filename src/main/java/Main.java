import observer.MessagePublisher;
import observer.MessageSubscriberOne;
import observer.MessageSubscriberThree;
import observer.MessageSubscriberTwo;
import observer.model.Message;

public class Main {

    public static void main(String[] args) {
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();
        MessageSubscriberThree s3 = new MessageSubscriberThree();

        MessagePublisher publisher = new MessagePublisher();

        // register s1 & s2
        publisher.attach(s1);
        publisher.attach(s2);

        // s1 and s2 will receive the update
        publisher.notify(new Message("First Message"));

        // unsubscribe s1
        publisher.detach(s1);

        // register s3
        publisher.attach(s3);

        // s2 and s3 will receive the update
        publisher.notify(new Message("Second Message"));
    }
}
