import util.KeyBoardUtil;

import java.time.Period;
import java.util.List;

public class Menu {
    private Task task;
    private boolean isExecuting = true;
    public Menu(){
        task = new Task();

        while (isExecuting){
            execute();
        }
    }

    public void execute(){
        int opt = KeyBoardUtil.getInt("1. Send\n2. Receive\n0. Exit\n");
        switch (opt){
            case 0:
                isExecuting = false;
                break;
            case 1:
                task.send();
                break;
            case 2:
                List<Car> cars = task.receive();
                for (Car car : cars){
                    System.out.println(car);
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
