package co.com.dannielf.basics_reactorrxjava.model;

public class Person {

    private final String id;
    private final String name;
    private final Integer age;

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
