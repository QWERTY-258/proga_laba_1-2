import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Laba_4 {
    public static void Testing(){
        System.out.println("Введите главную строку: ");
        Scanner scanner = new Scanner(System.in);
        String str_1 = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        StringBuilder str_2 = new StringBuilder(scanner.nextLine());
        //String str_1 = "101,.e,wiqe21ewq.324,12.101.,ds,as#adi0d";
        String new_str_1 = "";
        StringBuffer new_str_1_part_2 = new StringBuffer(str_1);
        //StringBuilder str_2 = new StringBuilder(",.");
        char[] ch_2 = str_2.toString().toCharArray();
        str_2 = new StringBuilder();
        for(int i = 0; i < ch_2.length; i++){
            if(ch_2[i] == '.' || ch_2[i] == '$' || ch_2[i] == '^' ||
                    ch_2[i] == '*' || ch_2[i] == '(' || ch_2[i] == ')' ||
                    ch_2[i] == '+' || ch_2[i] == '{' || ch_2[i] == '?' ||
                    ch_2[i] == '/'){
                str_2.append("\\").append(ch_2[i]);
            }
            else if(ch_2[i] == '\\'){
                str_2.append("\\\\");
            }
            else {
                str_2.append(ch_2[i]);
            }
            if(i != ch_2.length - 1){
                str_2.append("|");
            }
        }
        char[] ch_s;
        StringBuilder check_elem = new StringBuilder();
        boolean boo_s = true;
        StringBuilder str_2sist = new StringBuilder();
        StringBuilder str_lek = new StringBuilder();
        int i_2sist = 0;
        int i_lek = 0;
        System.out.println("Введите P:");
        int P = scanner.nextInt();
        //int P = 324;
        int first_P = -1;
        boolean boo_P = true;
        int index_first_lek = -1;
        boolean boo_first_lek = true;
        int i_last_2sist = -1;
        String last_2sist = "";
        for(String s: str_1.split(str_2.toString())){
            if(!s.isEmpty()){
                ch_s = s.toCharArray();
                for(int i = 0; i < s.length(); i++){
                    if (!(ch_s[i] == '1' || ch_s[i] == '0')) {
                        boo_s = false;
                        break;
                    }
                }
                if(boo_s){
                    if(str_2sist.length() > 0){
                        str_2sist.append(" || ");
                    }
                    str_2sist.append(s);
                    i_2sist++;
                    i_last_2sist = s.length();
                    last_2sist = s;
                }
                for(String new_s: s.split("[!@#$%^&*()_\\-+=~" +
                        "`}{\\[\\]:;'<,>.?]")){
                    check_elem.append(new_s);
                }
                if(check_elem.toString().equals(s)){
                    if(str_lek.length() > 0){
                    str_lek.append(" || ");
                }
                    str_lek.append(s);
                    i_lek++;
                }
                try {
                    if(Integer.parseInt(s) == P && boo_P){
                    first_P = str_1.indexOf(s);
                    boo_P = false;
                }
                }catch (NumberFormatException ignored){

                }
                if(boo_first_lek) {
                    index_first_lek = s.length();
                }
                boo_first_lek = false;
                boo_s = true;
                check_elem = new StringBuilder();
                System.out.print(s + " ");
            }
        }
        System.out.println();
        System.out.println(String.format("В строке были следующие числа " +
                "двоичной системы: %s, всего их: %d", str_2sist.toString(),i_2sist));
        System.out.println(String.format("В строке были следующие лексемы, " +
                "состоящие из цифр и из символов латинского алфавита: %s, " +
                "всего их: %d", str_lek.toString(),i_lek));
        if(first_P != -1){
            System.out.println(String.format("Позиция P = %d в изначальной строке: %d",
                    P, first_P));
        }
        else {
            System.out.println("P нет в начальной строке");
        }
        //new_str_1 = str_1.replace(last_2sist,"");
        new_str_1 = str_1.substring(0,str_1.lastIndexOf(last_2sist)) +
        str_1.substring((str_1.lastIndexOf(last_2sist) + i_last_2sist));
//        new_str_1_part_2.delete(str_1.lastIndexOf(last_2sist),
//                (str_1.lastIndexOf(last_2sist) + i_last_2sist));
        str_1 = new_str_1.substring(0, index_first_lek) +
                String.valueOf((int) pow(P,2)) + new_str_1.substring(index_first_lek);
//        str_1 = new_str_1_part_2.toString().substring(0, index_first_lek) +
//                String.valueOf((int) pow(P,2)) + new_str_1_part_2.toString().substring(index_first_lek);
        System.out.println(String.format("Новая строка: %s", str_1));
    }
}
