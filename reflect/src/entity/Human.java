package entity;

public final class Human {

    static {
        type = "priority";
    }

    public static String type;

    private String name;

    private Integer age;

    public Human() {
    }

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
