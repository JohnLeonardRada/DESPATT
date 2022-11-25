package model;

public class Message {

	//This must be an immutable object so that no class 
	//can modify it’s content by mistake.
	final String message;
    
    public Message (String message) {
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
}

