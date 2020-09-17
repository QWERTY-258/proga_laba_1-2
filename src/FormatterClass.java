import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Formatter;
import java.util.IllegalFormatConversionException;
import java.util.Scanner;

public class FormatterClass {
    public static void Fo() {
        Formatter formatter = new Formatter();
        System.out.println("Введите число типа BigInteger: ");
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = scanner.nextBigInteger();
        System.out.println(formatter.format("Число в восьмеричной записи:\n%o", bigInteger));
        formatter = new Formatter();
        System.out.println(formatter.format("Если число состоит меньше чем " +
                " из 4 символов, то выводит нули(минимальная ширина):\n%04o", bigInteger));
        formatter = new Formatter();
        System.out.println(formatter.format("Выводит от 5 до 7 символов в " +
                " строке(спецификатор точности):\n%5.7s", bigInteger));
        System.out.println("5 вариантов использования флагов формата:");
        System.out.printf("Выравниване влево:\n%-10d%n", bigInteger);
        System.out.printf("Положительные числа предваряются пробелом:\n% 10d%n", bigInteger);
        System.out.printf("Положительные числа предваряются знаком +:\n%+10d%n", bigInteger);
        System.out.printf("Числовые значения включают разделители групп:\n%,10d%n", bigInteger);
        System.out.printf("Отрицательные значения выводятся в скобках:\n%(10d%n", bigInteger);
        formatter = new Formatter();
        System.out.println(formatter.format("Число в шеснадцетиричной записи:\n%x", bigInteger));
        System.out.println("Введите число с плавующей точкой:");
        BigDecimal bigDecimal = scanner.nextBigDecimal();
        formatter = new Formatter();
        System.out.println(formatter.format("Второе число в шеснадцетиричной записи:" +
                "\n%f\n", bigDecimal));
        formatter = new Formatter();
        System.out.println(formatter.format("Используем индекс аргумента:" +
                " %3$s %1$s %2$s %3$s", "first_text", "second_text", "last_text"));
    }
}
