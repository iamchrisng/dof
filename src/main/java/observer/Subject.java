package observer;

import observer.model.Message;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notify(Message message);
}
