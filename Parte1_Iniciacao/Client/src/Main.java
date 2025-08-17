import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        //Socket é um cliente. Servidor é ServerSocket
        try(Socket socket = new Socket("localhost", 6338)){

            //Este senhor aqui permite enviarmos uma mensagem ao servidor
            //Se quisermos enviar objectos, teremos que usar ObjectOutputStream
            //ObjectOutputStream aprendemos em POO1 e usavamos para salvar dados no ficheiro de objectos
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            //Agora, este senhor aqui permite capturarmos mensagens do servidor
            //Se quisermos receber objectos, teremos que usar ObjectInputStream
            //ObjectInputStream também aprendemos em POO1 para ler dados de um ficheiro de objectos
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Imprimindo a mensagem do servidor
            System.out.println("O servidor disse: " + br.readLine());

            //Enviando mensagem para o servidor
            pw.println("Obrigado por aceitar minha conexao.");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}