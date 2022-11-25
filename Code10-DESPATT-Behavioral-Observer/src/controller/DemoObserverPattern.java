package controller;

import model.*;

import utility.*;

public class DemoObserverPattern {

	public static void main(String[] args) {
		MessageSubscriberOne subscriber1 = new MessageSubscriberOne();
        MessageSubscriberTwo subscriber2 = new MessageSubscriberTwo();
        MessageSubscriberThree subscriber3 = new MessageSubscriberThree();
         
        MessagePublisher msgPublisher = new MessagePublisher();
         
        msgPublisher.subscribe(subscriber1);
        msgPublisher.subscribe(subscriber2);
         
        //subscriber1 and subscriber2 will receive the update
        msgPublisher.notifyUpdate(new Message("First Message"));            
   
        msgPublisher.unsubscribe(subscriber1);
        msgPublisher.subscribe(subscriber3);
         
        //subscriber2 and subscriber3 will receive the update
        msgPublisher.notifyUpdate(new Message("Second Message")); 
	}
}


