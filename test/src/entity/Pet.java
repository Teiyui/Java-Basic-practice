package entity;

/**
 * 测试一：用于测试loadClass是否能触发静态代码块
 */
public class Pet {

    static {
        type = "inferiority";
    }

    public static String type;

    private String name;

    private Integer age;

    public Pet() {
    }

    public Pet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
