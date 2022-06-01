package co.com.dannielf.basics_reactorrxjava.doOnNext;

import co.com.dannielf.basics_reactorrxjava.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class DoOnNext {

    private static final Logger log = LoggerFactory.getLogger(DoOnNext.class);

    public static void reactor() {
        Mono.just(new Person("1", "Jhon", 30))
                .doOnNext(p -> log.info("Person name: {}", p.name().toUpperCase()))
                .subscribe(p -> log.info("[Reactor] Persona = {}", p));
    }

    public static void rxjava2() {
        Observable.just(new Person("1", "Jhon", 30))
                .doOnNext(p -> log.info("Person name: {}", p.name().toLowerCase()))
                .subscribe(p -> log.info("[RxJava] Persona = {}", p));
    }

    public static void main(String[] args) {
        reactor();
        rxjava2();
    }
}
