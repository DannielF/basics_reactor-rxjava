package co.com.dannielf.basics_reactorrxjava.merge;


import co.com.dannielf.basics_reactorrxjava.model.Hero;
import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Merge zip - zipWith
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Merge {

    private static final Logger log = LoggerFactory.getLogger(Merge.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 20),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 30));

    private static final List<Hero> heroes = List.of(new Hero("Hector", "ClusterMan"),
            new Hero("Maria", "Nightmare"),
            new Hero("Luis", "FireStorm"));

    public static void merge() {

        var fx1 = Flux.fromIterable(people);
        var fx2 = Flux.fromIterable(heroes);

        // fx, fx, fx..n
        Flux.merge(fx1, fx2)
                .subscribe(e -> log.info(e.toString()));
    }

    public static void zip() {

        var fx1 = Flux.fromIterable(people);
        var fx2 = Flux.fromIterable(heroes);

        Flux.zip(fx1, fx2, (p, h) -> String.format("Flux 1: %s , Flux 2: %s", p, h))
                .subscribe(log::info);

        // fx, fx, fx..n
        Flux.zip(fx1, fx2)
                .subscribe(e -> log.info(e.toString()));
    }

    public static void zipWith() {

        var fx1 = Flux.fromIterable(people);
        var fx2 = Flux.fromIterable(heroes);

        fx1.zipWith(fx2, (p, h) -> String.format("Flux 1: %s , Flux 2: %s", p, h))
                .subscribe(log::info);
    }

    public static void main(String[] args) {
        merge();
        zip();
        zipWith();
    }
}
