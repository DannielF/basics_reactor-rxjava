package co.com.dannielf.basics_reactorrxjava.subscribe;


import co.com.dannielf.basics_reactorrxjava.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Subscribe {

    private static final Logger log = LoggerFactory.getLogger(Subscribe.class);

    public static void reactor() {
        Mono.just(new Person("1", "Jhon", 30))
                .subscribe(p -> log.info("[Reactor] Persona = {}", p));
    }

    public static void rxjava2() {
        Observable.just(new Person("1", "Jhon", 30))
                .subscribe(p -> log.info("[RxJava] Persona = {}", p));
    }

    public static void main(String[] args) {
        reactor();
        rxjava2();
    }
}
