package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestFileIO {
    public static void main(String[] args) {

        try {

            Path path1 = Path.of("RamonaToJoey/message.txt");
            Path path2 = Path.of("RamonaToJoey/animal.txt");


            if (Files.notExists(path1)) {
                Files.createDirectories(path1.getParent());
                System.out.println("Directory created");
            } else {
                System.out.println("Directory already exist");
            }
            if (Files.notExists(path2)) {
                Files.createDirectories(path1.getParent());
                System.out.println("Directory 2 created");
            } else {
                System.out.println("Directory already exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter("RamonaToJoey/message.txt"));
            writer.write(" What do you call a bear with no teeth?");
            writer.write("\n A gummy bear !");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            BufferedReader reader = new BufferedReader
                    (new FileReader("RamonaToJoey/message.txt"));
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write
        Roe roe = new Roe("Bonny ", true);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("RamonaToJoey/animal.txt"))) {
            objectOutputStream.writeObject(roe);
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }

        // read
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("RamonaToJoey/animal.txt"))) {

            Roe animal = (Roe) objectInputStream.readObject();
            System.out.println(animal);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();


        }


    }
}


