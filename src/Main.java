import java.io.*;
import java.util.*;

// Division may not work properly since attributes of Complex class are integers
// The result of division gets floored to 0

//Output arrays are serialized, then deserialized and printed on the terminal

public class Main {
    public static void main(String[] args) throws IOException {
        Random random = new Random();

        ArrayList<Complex> arr1 = new ArrayList<>();
        ArrayList<Complex> arr2 = new ArrayList<>();
        ArrayList<Complex> Addition = new ArrayList<>();
        ArrayList<Complex> Subtraction = new ArrayList<>();
        ArrayList<Complex> Multiplication = new ArrayList<>();
        ArrayList<Complex> Division = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            int real = random.nextInt(100);
            int imag = random.nextInt(100);

            arr1.add(new Complex(real, imag));

            real = random.nextInt(100);
            imag = random.nextInt(100);

            arr2.add(new Complex(real, imag));
        }

        //addition
        for (int i = 0; i < 10; i++) {
            Addition.add((arr1.get(i).addition(arr2.get(i))));
        }

        //subtraction
        for (int i = 0; i < 10; i++) {
            Subtraction.add((arr1.get(i).subtract(arr2.get(i))));
        }

        //multiplication
        for (int i = 0; i < 10; i++) {
            Multiplication.add((arr1.get(i).multiply(arr2.get(i))));
        }

        //division
        for (int i = 0; i < 10; i++) {
            Division.add((arr1.get(i).divide(arr2.get(i))));
        }

        //Input Arrays
        System.out.println("Array 1: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr1.get(i));
        }

        System.out.println("Array 2: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr2.get(i));
        }

        //Serialization
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Addition.txt")))
        {
            oos.writeObject(Addition);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Subtraction.txt")))
        {
            oos.writeObject(Subtraction);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Multiplication.txt")))
        {
            oos.writeObject(Multiplication);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Division.txt")))
        {
            oos.writeObject(Division);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Deserialization
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Addition.txt")))
        {
            Addition = (ArrayList<Complex>) ois.readObject();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Subtraction.txt")))
        {
            Subtraction = (ArrayList<Complex>) ois.readObject();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Multiplication.txt")))
        {
            Multiplication = (ArrayList<Complex>) ois.readObject();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Division.txt")))
        {
            Division = (ArrayList<Complex>) ois.readObject();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Printing output arrays on terminal
        System.out.println("Addition: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(Addition.get(i));
        }

        System.out.println("Subtraction: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(Subtraction.get(i));
        }

        System.out.println("Multiplication: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(Multiplication.get(i));
        }

        System.out.println("Division: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(Division.get(i));
        }
    }
}