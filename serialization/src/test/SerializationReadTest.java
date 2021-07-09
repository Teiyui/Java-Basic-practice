package test;

import entity.Pet;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializationReadTest {

    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\SerializableObject\\pet.txt")));
        Pet pet = (Pet) ois.readObject();
        ois.close();

        System.out.println("反序列化结果为：");
        System.out.println(pet);
    }
}
