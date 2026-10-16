import java.util.Scanner;

public class User{
    private String name;
    private String cpf;
    private int age;

    Scanner scanner = new Scanner(System.in);

    public User(String name, String cpf, int age){
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public boolean isEligible(){
        return age >= 18 && isCPFvalid();
    }

    public boolean isCPFvalid(){
        if(cpf.length()!= 11){
            return false;
        }
        for(int x = 0; x < cpf.length(); x++ ){
            char word = cpf.charAt(x);
            if(!Character.isDigit(word)){
                return false;
            }
        }
        int multi = 10;
        int count = 0;

        for (int i = 0; i < 9; i ++){
            int numero = Character.getNumericValue(cpf.charAt(i));
            numero = numero * multi;
            count = count + numero;
            multi -= 1;
        }
        count = count % 11;
        int numberCpf = 11 - count;
        if(numberCpf >= 10){
            numberCpf = 0;
        }
        int numero = Character.getNumericValue(cpf.charAt(9));
        if(numberCpf != numero){
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public String getCpf(){
        return cpf;
    }

    public int getAge(){
        return age;
    }
}