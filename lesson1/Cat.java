package java2.lesson1;


public class Cat extends Team implements Run, Jump {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Кот " + this.name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + this.name + " прыгает");

    }
}
