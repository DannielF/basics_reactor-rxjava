package co.com.dannielf.basics_reactorrxjava.transform;


import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Transform map - flatMap - groupBy
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Transform {

    private static final Logger log = LoggerFactory.getLogger(Transform.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 30),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 20));

    public static void map() {

        Flux.fromIterable(people)
                .map(p -> {
                    p.updateAge(p.age() + 5);
                    return p;
                })
                .subscribe(p -> log.info("Person name: {} - age: {}", p.name(), p.age()));
    }

    public static void flatMap() {

        Flux.fromIterable(people)
                .flatMap(p -> {
                    p.updateAge(p.age() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info("Person name: {} - age: {}", p.name(), p.age()));
    }

    public static void groupBy() {

        Flux.fromIterable(people)
                .groupBy(Person::age)
                .flatMap(Flux::collectList)
                .subscribe(p -> log.info(p.toString()));
    }

    public static void main(String[] args) {
        map();
        flatMap();
        groupBy();
    }
}
