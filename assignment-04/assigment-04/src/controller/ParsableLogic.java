package controller;


public class ParsableLogic {

    public String a;
    public String b;
    public int sum;
    public boolean isnumber;

    public ParsableLogic(String a, String b){
        this.a = a;
        this.b = b;

        try {
            int a_int = Integer.parseInt(a);
            int b_int = Integer.parseInt(b);
            sum = a_int + b_int;
            isnumber = true;
        } catch (NumberFormatException ex) {
            isnumber = false;
        }
    }

    public boolean isParsable(){
        return isnumber;
    }

    public Model result(){
        return new Model(sum+"");
    }

    public String toString(){
        return sum + "";
    }
}
