import util.KeyBoardUtil;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Task {

    public Task(){

    }

    public void send(){
        try(Socket socket = new Socket("localhost", 6338)){
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("SAVE");
            outputStream.flush();
            outputStream.writeObject(getAllCars());
            outputStream.flush();
            outputStream.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Car> receive(){
        List<Car> cars = null;
        try(Socket socket = new Socket("localhost", 6338)){
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("READ");
            outputStream.flush();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            cars = (List<Car>) inputStream.readObject();
            outputStream.close();
            inputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return cars;
    }

    private List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();
        int quant = KeyBoardUtil.getInt("How many cars: ");
        for(int i = 0; i < quant; i++)
            cars.add(getCar());

        return cars;
    }

    private Car getCar(){
        String model = KeyBoardUtil.getString("Model: ");
        int year = KeyBoardUtil.getInt("Year: ");
        String color = KeyBoardUtil.getString("Color: ");
        return new Car(model, year, color);
    }


}
