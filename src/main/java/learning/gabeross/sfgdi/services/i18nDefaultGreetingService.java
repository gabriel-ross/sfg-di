package learning.gabeross.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"RUS", "default"})
@Service("i18nService")
public class i18nDefaultGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "You are running the default profile";
    }
}
