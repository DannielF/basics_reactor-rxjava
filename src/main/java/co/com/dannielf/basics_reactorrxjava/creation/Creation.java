package co.com.dannielf.basics_reactorrxjava.creation;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Creation Mono-Flux, range-repeat
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Creation {

    private static final Logger log = LoggerFactory.getLogger(Creation.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 30),
            new Person("2", "Mario", 99));

    public static void justFrom() {

        Mono.just("");
        Flux.fromIterable(people);
        Observable.just("");
    }

    public static void empty() {

        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public static void rangeFlux() {

        Flux.range(0, 3)
                .doOnNext(i -> log.info("i = {}", i))
                .subscribe();
    }

    public static void repeatFluxAndMono() {

        Flux.fromIterable(people)
                .repeat(2)
                .subscribe(p -> log.info(p.toString()));

        Mono.just(new Person("2", "Mario", 99))
                .repeat(2)
                .subscribe(p -> log.info(p.toString()));
    }
}
