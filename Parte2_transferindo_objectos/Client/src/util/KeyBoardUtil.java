package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoardUtil {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String getString(String text){
        String s = "";
        System.out.print(text);
        do{
            try{
                s = br.readLine();
                if(s.trim().isEmpty())
                    System.out.print("Invalid entrance. Insert again: ");
            }catch (IOException e){
                System.out.println("");
            }
        }while (s.trim().isEmpty());

        return s;
    }

    public static int getInt(String tex){
        int num = 0;
        System.out.print(tex);
        boolean passed = true;
        do{
            try{
                num = Integer.parseInt(br.readLine());
            }catch (IOException ignored){

            }catch (NumberFormatException nf){
                passed = false;
                System.out.println("Ups! Not a Number. Insert again: ");
            }
        }while (!passed);

        return num;
    }
}
