package utility;

import java.util.ArrayList;
import java.util.List;

import model.Message;

public class MessagePublisher implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	 
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
 
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
 
    @Override
    public void notifyUpdate(Message message) {
        for(Observer observer: observers) {
            observer.update(message);
        }
        
        //TODO as a non-graded exercise
        //convert the above code using the Iterator
        
    }
}


