package demo.patterns.prototypepattern.model;

public class AccessPrototypeDemo {

	static {
		System.out.println("static inside main");
	}
	public static void main(String[] args){
		 System.out.println("inside main()");
		 Person prototype =  Factory.getPrototype("marty");
		 
         if (prototype != null) {
             System.out.println(prototype.toString());
         }
	}
}

