package co.com.dannielf.basics_reactorrxjava.error;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Error retry - errorReturn - errorResume - errorMap
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Error {

    private static final Logger log = LoggerFactory.getLogger(Error.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 20),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 30));

    public static void retry() {

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("Error")))
                .retry(1)
                .doOnNext(ele -> log.info(ele.toString()))
                .subscribe();
    }

    public static void errorReturn() {

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("Error")))
                .onErrorReturn(new Person("0", "XXX", 99))
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void errorResume() {

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("Error")))
                .onErrorResume(e -> Mono.just(new Person("0", "XXX", 99)))
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void errorMap() {

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("Error")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void main(String[] args) {
        retry();
        errorResume();
        errorReturn();
        errorMap();
    }
}
