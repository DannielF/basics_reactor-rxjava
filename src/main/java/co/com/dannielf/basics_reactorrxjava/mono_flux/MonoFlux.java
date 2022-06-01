package co.com.dannielf.basics_reactorrxjava.mono_flux;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Mono and Flux publisher
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class MonoFlux {

    private static final Logger log = LoggerFactory.getLogger(MonoFlux.class);

    private static final List<Person> people = List.of(new Person("1", "Jhon", 30),
            new Person("2", "Mario", 99));

    public static void mono() {
        Mono.just(new Person("1", "Jhon", 30))
                .subscribe(p -> log.info("[Mono] Persona = {}", p));
    }

    public static void flux() {
        Flux.fromIterable(people)
                .subscribe(p -> log.info("[Flux] Persona name {} - age {}", p.name(), p.age()));
    }

    public static void fluxToMono() {
        var fx = Flux.fromIterable(people);

        fx.collectList()
                .subscribe(people -> log.info(people.toString()));
    }

    public static void main(String[] args) {
        mono();
        flux();
        fluxToMono();
    }
}
