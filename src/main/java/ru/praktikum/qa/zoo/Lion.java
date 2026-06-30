package ru.praktikum.qa.zoo;

import java.util.List;

public class Lion {

    private final Predator predator;

//    boolean hasMane;
    private boolean hasMane;

    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator;
//   public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

//    Feline feline = new Feline();

//    public int getKittens() {
////        return feline.getKittens();
//        return 0;
//    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
//        return feline.getFood("Хищник");
        return predator.eatMeat();
    }
}
