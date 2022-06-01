package co.com.dannielf.basics_reactorrxjava.model;

/**
 * Hero Model
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class Hero {

    private String id;
    private String name;
    private String nickName;

    public Hero(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public String name() {
        return name;
    }

    public String nickName() {
        return nickName;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero {" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
