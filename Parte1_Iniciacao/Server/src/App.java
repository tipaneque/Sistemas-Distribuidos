import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        int port = 6338;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            //Só para mostrar que o servidor está a correr kkkkk
            System.out.println("Server listening to port " + port); 

            //Colegas, o servidor aguarda pelo cliente aqui.
            //ServerSocket é o socket do servidor e Socket é o socket do cliente
            Socket socket = serverSocket.accept();

            

            //Vamos lá entao mandar uma mensagem para o cliente
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw.println("senhor cliente, eu recebi sua conexao");

            //Vamos la receber a mensagem do cliente
            
            System.out.println("O cliente disse: " + br.readLine());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
