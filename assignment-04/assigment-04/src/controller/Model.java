package controller;


public class Model {

    public String result;

    public Model(String r) {
        this.result = r;
    }


    public String getResult(){
        return result;
    }



    @Override
    public String toString(){
        return result + "";
    }

}
