package learning.gabeross.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Greeting service by setter";
    }
}
