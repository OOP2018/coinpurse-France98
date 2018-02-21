package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Phanuwatch Luangpradit
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	init();
    	Purse purse = new Purse(10);
    	ConsoleDialog ui = new ConsoleDialog(purse);
    	ui.run();
    }
    
    public static void init(){
    	ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
    	String factoryclass = bundle.getString("moneyfactory");
    	//TODO if factoryclass is null then use a default class name
    	MoneyFactory factory = null;
    	try {
    	 factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
    	 MoneyFactory.setMoneyFactory(factory);
    	}
    	catch (ClassCastException cce) {
    	 //the object could not be cast to type MoneyFactory
    	 System.out.println(factoryclass +" is not type MoneyFactory");
    	 MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());  //Set as default
    	}
    	catch (Exception ex) {
    	 // any other exception means we could not create an object
    	 System.out.println("Error creating MoneyFactory "+ ex.getMessage() );
    	}
    	// if no factory then quit
    	if (factory == null) System.exit(1);
    }
}
