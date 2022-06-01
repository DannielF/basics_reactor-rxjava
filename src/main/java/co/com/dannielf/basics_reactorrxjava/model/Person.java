package co.com.dannielf.basics_reactorrxjava.model;

import java.util.Objects;

/**
 * Person class
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Person {

    private String id;
    private String name;
    private Integer age;

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

    public void updateName(String name) {
        this.name = name;
    }

    public void updateAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
