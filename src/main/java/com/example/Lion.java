package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private Beast beast;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    public Lion(Beast beast){
        this.beast = beast;
    }

    public int getKittens() {
        return beast.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return beast.getFood("Хищник");
    }
}
