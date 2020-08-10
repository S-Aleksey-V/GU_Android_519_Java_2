package java2.lesson1;

public class Robot extends Team implements Run, Jump {

    public Robot(String name) {
        super(name);
    }

    @Override
    public void jump() {
        System.out.println("Робот " + this.name + " прыгает");
    }

    @Override
    public void run() {
        System.out.println("Робот " + this.name + " Бежит");
    }
}
