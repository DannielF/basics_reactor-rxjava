package co.com.dannielf.basics_reactorrxjava.filter;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Filter take - distinct - takeLast - skipLast
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Filter {

    private static final Logger log = LoggerFactory.getLogger(Filter.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 20),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 30));

    public static void filter() {

        Flux.fromIterable(people)
                .filter(p -> p.age() >= 30)
                .subscribe(p -> log.info(p.toString()));
    }

    public static void distinct() {

        Flux.fromIterable(people)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public static void take() {

        Flux.fromIterable(people)
                .take(1L)
                .subscribe(p -> log.info(p.toString()));
    }

    public static void takeLast() {

        Flux.fromIterable(people)
                .takeLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public static void skipLast() {

        Flux.fromIterable(people)
                .skipLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public static void main(String[] args) {
        filter();
        distinct();
        take();
        takeLast();
        skipLast();
    }
}
