import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.pow;

public class bigInteger {
    public static String end() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение x (от -1 до 1):");
        double bb = sc.nextDouble();
        if(bb >= 1 || bb <= -1){
            return "Вы ввели недопустимое значение";
        }
        System.out.println("Введите значение k (натуральное число):");
        int k = sc.nextInt();
        System.out.println("arctan через встроенный вариант:");
        System.out.println(atan(bb));
        BigDecimal x = BigDecimal.valueOf(bb);
        BigDecimal e = BigDecimal.valueOf((double) pow(10, -k));

        String str = "1.";
        for(int j = 0; j < k + 1; j++){
            str += "0";
        }
        System.out.println("arctan после выполнения подсчетов:");
        if(x.compareTo(BigDecimal.valueOf(0)) == 0){
            return "0.0";
        }
        BigDecimal xK = new BigDecimal(str);
        BigDecimal end = new BigDecimal("0");
        int bool = 1;
        double i = 1;
        while((xK.compareTo(e) < 0 && xK.compareTo(BigDecimal.valueOf(0)) < 0) ||
                (xK.compareTo(e) > 0 && xK.compareTo(BigDecimal.valueOf(0)) > 0) ||
                xK.compareTo(BigDecimal.valueOf(0)) == 0){
            xK = new BigDecimal(str);
            for(int j = 0; j < i; j++){
                xK = xK.multiply(x);
            }
            xK = xK.multiply(BigDecimal.valueOf(bool));
            xK = xK.divide(BigDecimal.valueOf(i), BigDecimal.ROUND_CEILING);
            end = end.add(xK);
            i += 2;
            if(bool == 1){
                bool = -1;
            }
            else{
                bool = 1;
            }
        }
        char[] ch = ("" + end).toCharArray();
        if(ch[0] == 45){
            return ("" + end).substring(0,k + 4);
        }
        else{
            return ("" + end).substring(0,k + 3);
        }
    }
}
