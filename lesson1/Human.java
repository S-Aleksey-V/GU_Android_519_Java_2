package java2.lesson1;

public class Human extends Team implements Run, Jump {

    public Human(String name) {
        super(name);
    }

    @Override
    public void jump() {
        System.out.println("Человек " + this.name + " прыгает");

    }

    @Override
    public void run() {
        System.out.println("Человек " + this.name + " бежит");
    }


}
