package co.com.dannielf.basics_reactorrxjava.model;

/**
 * Person class
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Person {

    private final String id;
    private final String name;
    private final Integer age;

    /**
     * Person's constructor
     *
     * @param id   String
     * @param name String
     * @param age  Integer
     */
    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public Integer age() {
        return age;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
