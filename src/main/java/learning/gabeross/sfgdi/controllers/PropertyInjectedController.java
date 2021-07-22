package learning.gabeross.sfgdi.controllers;

import learning.gabeross.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// The controller annotation tells Spring that this is a Spring-managed component
@Controller
public class PropertyInjectedController {

    // This tells spring that we want it to inject an instance of the greeting service for us
    //@Autowired
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
