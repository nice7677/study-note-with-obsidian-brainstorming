package beanlifecycle;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DbInit {

    @PostConstruct
    private void postConstruct() {

        // Logic

    }


}
