package java2.lesson1;

import java.util.Random;

public class Obstacles {

    protected int HEIGHT_WALL;
    protected int LENGTH_TREADMILL;

    private String name;

    Random random = new Random();



    public Obstacles(String name) {
        this.name = name;
        HEIGHT_WALL = random.nextInt(100);
        LENGTH_TREADMILL= random.nextInt(100);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}

