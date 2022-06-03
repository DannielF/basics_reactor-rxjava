package co.com.dannielf.basics_reactorrxjava.conditional;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

/**
 * Conditional defaultIfEmpty - takeUntil - timeout - switchIfEmpty
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Conditional {

    private static final Logger log = LoggerFactory.getLogger(Conditional.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 20),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 30));

    public static void defaultIfEmpty() {

        Mono.empty()
                .defaultIfEmpty(new Person("0", "Default", 100))
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void takeUntil() {

        Flux.fromIterable(people)
                .takeUntil(p -> p.age() > 20)
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void timeout() throws InterruptedException {

        Flux.fromIterable(people)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .subscribe(ele -> log.info(ele.toString()));

        Thread.sleep(10000);
    }

    public static void switchIfEmpty() {

        Flux.empty()
                .switchIfEmpty(Mono.error(() -> new IllegalArgumentException("Could no resolve")))
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void main(String[] args) {
        defaultIfEmpty();
    }
}
