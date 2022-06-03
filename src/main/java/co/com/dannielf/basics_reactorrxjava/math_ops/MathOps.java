package co.com.dannielf.basics_reactorrxjava.math_ops;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MathOps average - count - min - sum - summarizing
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class MathOps {

    private static final Logger log = LoggerFactory.getLogger(MathOps.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 20),
            new Person("2", "Mario", 30),
            new Person("3", "Luigi", 30));

    public static void average() {

        Flux.fromIterable(people)
                .collect(Collectors.averagingInt(Person::age))
                .subscribe(p -> log.info(p.toString()));
    }

    public static void count() {

        Flux.fromIterable(people)
                .count()
                .subscribe(x -> log.info("Count is: {}", x));
    }

    public static void min() {

        Flux.fromIterable(people)
                .collect(Collectors.minBy(Comparator.comparing(Person::age)))
                .subscribe(p -> log.info(p.get().toString()));
    }

    public static void sum() {

        Flux.fromIterable(people)
                .collect(Collectors.summingInt(Person::age))
                .subscribe(x -> log.info("Sum is: {}", x));
    }

    public static void summarizing() {

        Flux.fromIterable(people)
                .collect(Collectors.summarizingInt(Person::age))
                .subscribe(x -> log.info("Summarizing is: {}", x));
    }

    public static void main(String[] args) {
        summarizing();
    }
}
