import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        int port = 6338;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                System.out.println("Server listening to port " + port);
                Socket socket = serverSocket.accept();
                try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                    var command = inputStream.readObject();
                    
                    if(command.equals("SAVE")){
                        FileManager.save(inputStream.readObject(), "cars.dat");
                    }else if(command.equals("READ")){
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeObject(FileManager.read("cars.dat"));
                    }else{
                        System.out.println("Comando invalido: " + command);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage()
            );
        }
    }
}
