package basis;

import entity.Human;
import entity.Pet;

/**
 * 面试题一：创建对象的几种方式
 * 问题分析：1. 首先想到new一个对象
 *         2. 其次想到通过类加载其将类的Class对象加载进JVM内存，再调用newInstance()方法创建对象
 *         3. 使用clone方法
 *         4. 使用反序列化
 */
public class CreateObject {

    public static void main(String[] args) throws Exception {
        // 方式一：通过类加载器加载类的Class对象进JVM内存，再调用newInstance方法创建对象
        // 考点：1. Class类为常量类并且其构造方法为私有方法，这就指明Class类无法被继承（防止子类对其方法的重写）以及无法new对象
        //      2. Class对象写入JVM内存的具体过程为：1). 调用静态代码块；2). 调用父类构造器；3). 调用本身构造器
        //      3. 要使用newInstance方法生成该类的对象的前提是该类需要有无参构造方法（且构造方法不被private修饰）
        Class humanClass = Class.forName("entity.Human");
        Class humanClass1 = Human.class;
        Human human = (Human) humanClass1.newInstance();

        // 方式二：是通过类加载器的loadClass方法加载该类的CLass对象进JVM内存
        // 考点：1. 与Class.forName()方法的区别时loadClass方法为延迟加载，不会执行该类的静态代码块和静态方法
        //      2. 承接1，所以常用在项目中某些类的初始化工作比较占内存时，通过loadClass避免执行静态代码块，等需要时尽早加载进JVM内存
        //      3. 总结：loadClass方法主要是为了延迟加载类的Class对象，并避免内存压力过大
        ClassLoader classLoader = CreateObject.class.getClassLoader();
        Class petClass = classLoader.loadClass("entity.Pet");
        Pet pet = (Pet) petClass.newInstance();
    }
}
