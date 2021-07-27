package learning.gabeross.sfgdi.services;

import org.springframework.stereotype.Service;

// We mark this with the service annotation to tell spring that this is a spring-managed component

// There really is no difference between service, component, and controller annotations -> just tells spring
// that this is a spring-managed component. The specific annotation is more documentation
@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World!!!!!! - Constructor";
    }
}
