import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

    //POO1
    public static void save(Object o, String fileName){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(o);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     //POO1
    public static Object read(String fileName){
        Object o = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            o = inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return o;
    }

}
