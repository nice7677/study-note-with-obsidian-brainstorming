package beanlifecycle;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DbDisposable {

    @PreDestroy
    private void preDestroy() {

        // Logic

    }

}
