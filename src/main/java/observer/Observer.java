package observer;

import observer.model.Message;

public interface Observer {

    void update(Message message);
}
