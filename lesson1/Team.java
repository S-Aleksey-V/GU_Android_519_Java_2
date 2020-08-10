package java2.lesson1;


import java.util.Random;

public abstract class Team extends Obstacles implements Run, Jump {

    private static int count = 1;
    protected String name;
    private int endurance;


    Random random = new Random();

    @Override
    public String getName() {
        return name;
    }

    public Team(String name) {
        super(name);
        this.name = name;
        endurance = random.nextInt(100);
    }


    public void teamInfo() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Team team[] = new Team[3];
        team[0] = new Human("Dad");
        team[1] = new Cat("Barsic");
        team[2] = new Robot("Android");

        Obstacles obstacles[] = new Obstacles[2];
        obstacles[0] = new Wall("Бешеная стена");
        obstacles[1] = new Treadmill("Бешеная дорога");

        for (int i = 0; i < team.length; i++) {

            System.out.println("Участник " + team[i].getName() + " выходит на полосу препядствий");

            for (int j = 0; j <count; j++) {
                System.out.println("Первое препядствие " + obstacles[j].getName());
                if (team[i].endurance >= obstacles[j].HEIGHT_WALL) {
                    System.out.println("Стена перепрыгнута");
                } else {
                    System.out.println("Не хватило сил перепрыгнуть");
                    System.out.println();
                    break;
                }

                System.out.println("Второе препядствие " + obstacles[j].getName());
                if (team[i].endurance >= obstacles[j].LENGTH_TREADMILL) {
                    System.out.println("дорожка пройдена");
                } else {
                    System.out.println("Не хватило сил пробежать");
                    System.out.println();
                    break;
                }

                System.out.println();

            }


        }
    }
}

