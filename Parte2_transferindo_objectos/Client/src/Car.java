import java.io.Serializable;
import java.util.UUID;

public class Car implements Serializable {
    private String code;
    private String model;
    private int year;
    private String color;

    public Car(String model, int year, String color) {
        this.code = UUID.randomUUID().toString();
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return model + "; " + code + "; " + year + "; " + color;
    }
}
