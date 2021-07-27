package learning.gabeross.sfgdi;

import learning.gabeross.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		// .run returns an application context that we can assign to a variable
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		// We need to cast to MyController type since the func just returns back object type
		// the myController in getBean must start with a lowercase
		// When this starts up spring goes through and adds things annotated with @Bean to the context
		MyController myController = (MyController) ctx.getBean("myController");

		// Notice that we never created a MyController instance using new MyController();
		// spring is creating that for us - it is saying "create a new instance of this class and put it into the context"
		// Then we're saying with ctx.getBean we want spring to provide us an instance of this bean from the context
		// this is called inversion of control - spring is managing instantiation of the controller

		// That is the essence of dependency injection -> the framework is going and creating all the necessary objects for you
		// and providing the instantiated objects for you. That way the user avoids having to manage so much

		// One example is a database connection object, which is a pretty expensive operation. The class that requires
		// that database connection just requires the data. Spring can handle interacting with the database, be it H2,
		// or SQL, etc. All of this abstracts that database connection

		// Best practice is to have dependencies injected via constructor !!!!!!!!
		// Other, less preferable ways, are by setters or by class fields (rly bad)

		// DI can be done with interfaces or concrete classes, but is best done by interfaces.
			// follows interface segregation principle - SOLID
			// More testable
			// Allows runtime to decide on implementation to inject

		// Inversion of control -> the class itself is not controlling the injection (not asking for an object),
		// the framework is deciding what gets injected at runtime

		// Classes are built with DI in mind -> we'll compose a class that requires a data source that will later
		// be injected

		// IOC is the runtime env of the code. Spring's IOC container - Spring is controlling the injection

		// BEST PRACTICES:
			// Inject using constructors
			// use final properties for injected components
			// if possible, code to an interface

		//String greeting = myController.sayHello();

		System.out.println("----Primary bean ex");
		System.out.println(myController.sayHello());

		System.out.println("-------------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		//propertyInjectedController.greetingService = new ConstructorGreetingService();
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------- Setter-based");
		// Recall the name in .getBean() is not the var name, but rather the class name with the first letter lower-cased
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------- Constructor-based");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
