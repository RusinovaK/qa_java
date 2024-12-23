package com.example;

import java.util.List;

public interface Beast {
    List<String> getFood(String animalKind) throws Exception;
    int getKittens();
    int getKittens(int kittensCount);
}
