public class User{
    private String name;
    private String cpf;
    private int age;

    public User(String name, String cpf, int age){
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public boolean isEligible(){
        boolean nameValid = isNAMEvalid();
        boolean cpfValid = isCPFvalid();
        boolean ageValid = isAGEvalid();

        return nameValid && cpfValid && ageValid;
    }

    public boolean isCPFvalid(){
        if (cpf == null || cpf.isBlank()) {
            System.out.print("CPF cannot be empty ");
            return false;
        }

        if(cpf.length()!= 11){
            return false;
        }

        for(int x = 0; x < cpf.length(); x++ ){
            char word = cpf.charAt(x);
            if(!Character.isDigit(word)){
                return false;
            }
        }

        if (!DifferentNumber()){
            return false;
        }

        if (!FirstNumberValid() || !SecondNumberValid()){
            return false;
        }
        return true;
    }

    public boolean DifferentNumber(){
        for(int x = 1; x < cpf.length(); x++ ){
            if (cpf.charAt(0) != cpf.charAt(x)) {
                return true;
            }
        }
        return false;
    }
    public boolean FirstNumberValid(){
        int multi = 10;
        int count = 0;

        for (int i = 0; i < 9; i ++){
            int numero = Character.getNumericValue(cpf.charAt(i));
            numero = numero * multi;
            count = count + numero;
            multi -= 1;
        }

        count = count % 11;
        int numberCpf;

        if(count < 2){
            numberCpf = 0;
        } else {
            numberCpf = 11 - count;
        }

        int numero = Character.getNumericValue(cpf.charAt(9));

        if(numberCpf != numero){
            return false;
        }
        return true;
    }
    public boolean SecondNumberValid(){
        int multi = 11;
        int count = 0;

        for (int i = 0; i < 10; i ++){
            int numero = Character.getNumericValue(cpf.charAt(i));
            numero = numero * multi;
            count = count + numero;
            multi -= 1;
        }

        count = count % 11;
        int numberCpf;

        if(count < 2){
            numberCpf = 0;
        } else {
            numberCpf = 11 - count;
        }

        int numero = Character.getNumericValue(cpf.charAt(10));

        if(numberCpf != numero){
            return false;
        }
        return true;
    }
    public boolean isNAMEvalid(){
        if (name == null ||  name.isBlank()){
            System.out.print("Name cannot be empty ");
            return false;
        }
        return true;
    }

    public boolean isAGEvalid(){
        if (18 > age || age > 120) {
            System.out.println("Invalid age");
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