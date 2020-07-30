package java2.lesson3;

import java.util.*;

public class Collections {

    public static void main(String[] args) {

        String [] list = new String[] {"машина","самолёт","автобус","вертолёт","велосипед","машина","самолёт","автобус","вертолёт","велосипед","машина","самолёт","автобус","вертолёт","велосипед","вертолёт"};
        System.out.println("Весь масив : " + Arrays.toString(list));

        Set<String> set = new HashSet<>(Arrays.asList(list));
        System.out.println("уникальные слова " + set);

        Map<String,Integer> doubleNames = new HashMap<>();
        Integer doubleName;
        for(String i : list){
            doubleName = doubleNames.get(i);
            doubleNames.put(i, doubleName == null ? 1 : doubleName + 1);

        }
        System.out.println("Повторяющиеся слова " + doubleNames);



    }


}
