import java.text.NumberFormat;
import java.util.*;

class Comp implements Comparator<Arr>{

    @Override
    public int compare(Arr o1, Arr o2) {

        return o1.num - o2.num;
    }
}
class Arr{
    int num;
    public Arr(int num){
        this.num = num;
    }
    @Override
    public String toString(){
        return "" + num;
    }
}
public class Laba_3{
    private static void matrix_out(Integer[][] x, boolean boo){
        System.out.println("");
        for(int i = 0; i < x.length; i++){
            for (int j = 0; j < x.length; j++){
                if(!boo){
                    System.out.print(x[i][j] + " ");
                }
                else {
                    System.out.print(NumberFormat.getPercentInstance()
                            .format(x[i][j]));
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public static void testing(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Размерность квадратной матрицы:");
        Random random = new Random();
        int n = sc.nextInt();
        Integer[][] matrix_1 = new Integer[n][n];
        Integer[][] matrix_2 = new Integer[n][n];
        Integer[][] matrix_3 = new Integer[n][n];
        Integer[][] matrix_4 = new Integer[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix_1[i][j] = random.nextInt(100) + 100;
                matrix_4[i][j] = matrix_1[i][j];
            }
        }
        System.out.println("\nИзначальная матрица (в обоих видах):");
        matrix_out(matrix_1, false);
        matrix_out(matrix_1, true);
        int help_int;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i < j){
                    help_int = matrix_1[i][j];
                    matrix_1[i][j] = matrix_1[j][i];
                    matrix_1[j][i] = help_int;

                    matrix_4[i][j] = matrix_1[i][j];
                    matrix_4[j][i] = matrix_1[j][i];

                    matrix_2[i][j] = j + 1;
                    matrix_2[j][i] = i + 1;

                    matrix_3[i][j] = i + 1;
                    matrix_3[j][i] = j + 1;
                }
                if(i == j){
                    matrix_2[i][j] = 0;
                    matrix_3[i][j] = 0;
                }
            }
        }
        System.out.println("Новая матрица (в обоих видах):");
        matrix_out(matrix_1, false);
        matrix_out(matrix_1, true);
        System.out.println("Позиции переноса по строкам:");
        matrix_out(matrix_2, false);
        System.out.println("Позиции переноса по столбцам:");
        matrix_out(matrix_3, false);

        boolean b = false;
        int new_n = 0;
        int new_m = 0;
        while (!((new_n < new_m) && (new_n >= 0) && (new_m <= n))){
            if(b){
                System.out.println("\nВы ввели недопустимые значения!!\n");
            }
            System.out.println("Введите индекс числа, начиная " +
                    "с которого надо сортировать строку");
            new_n = sc.nextInt();
            System.out.println("\nВведите индекс последнего числа, " +
                    "которое вы хотете отсортировать");
            new_m = sc.nextInt();
            b = true;
        }
        Comp comp = new Comp();
        Set set = new TreeSet(comp);
        Integer[] help_machine = new Integer[new_m - new_n];
        for(int i = new_n; i < new_m; i++){
            set.add(new Arr(matrix_1[0][i]));
        }
        int k = 0;
        String string = "";
        for(Object o: set){
            help_machine[k++] = Integer.parseInt(o.toString());
        }
        k = 0;
        for(int i = 0; i < n; i++){
            if(new_n <= i && new_m > i){
                matrix_4[0][i] = help_machine[k++];
            }
        }
        System.out.println("\nНовая матрица, преобразованая с помощью Comparator " +
                "(в обоих видах): ");
        matrix_out(matrix_4, false);
        matrix_out(matrix_4, true);
    }
}
