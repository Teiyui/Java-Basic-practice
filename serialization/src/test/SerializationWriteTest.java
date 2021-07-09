package test;

import entity.Pet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationWriteTest {

    public static void main(String[] args) throws Exception {
        Pet pet = new Pet();
        pet.setName("dog");
        pet.setAge(7);
        pet.setAddress("安徽省合肥市瑶海区教师新村A区二栋106");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\SerializableObject\\pet.txt")));
        oos.writeObject(pet);
        oos.close();

        System.out.println("序列化成功！已经生成pet.txt文件");
    }
}
