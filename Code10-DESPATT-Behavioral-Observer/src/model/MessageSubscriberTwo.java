package model;

import utility.Observer;

public class MessageSubscriberTwo implements Observer {

	@Override
    public void update(Message message) {
        System.out.println("MessageSubscriberTwo: " 
        	+ message.getMessage());
    }
}

