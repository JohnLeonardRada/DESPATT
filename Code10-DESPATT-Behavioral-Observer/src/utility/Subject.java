package utility;

import model.Message;

public interface Subject {
	
	public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyUpdate(Message message);
}

