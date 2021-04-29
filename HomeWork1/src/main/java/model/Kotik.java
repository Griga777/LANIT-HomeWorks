package model;

public class Kotik {
    private String name, nameFood, meow;
    private int weight, prettiness;
    private int catSatiety = 22;
    private static int count = 0;

    public void liveAnotherDay() {
        int rnd;
        int H = 5;
        for (int i = 0; i < 24; i++) {
            if (catSatiety <= 0) {
                System.out.println(name + " хочет есть");
                eat();
            }
            rnd = (int) (Math.random() * H + 1);
            switch (rnd) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    chaseMouse();
                    break;
                case 4:
                    walk();
                    break;
                case 5:
                    jump();
                    break;
            }
        }
    }

    public boolean play() {
        System.out.println(name + " поиграл с клубком");
        catSatiety--;
        return false;
    }

    public boolean sleep() {
        System.out.println(name + " поспал на кровати");
        catSatiety--;
        return false;
    }

    public boolean chaseMouse() {
        System.out.println(name + " поймал мышь");
        catSatiety--;
        return false;
    }

    public boolean walk() {
        System.out.println(name + " погулял на улице");
        catSatiety--;
        return false;
    }

    public boolean jump() {
        System.out.println(name + " попрыгал на диван");
        catSatiety--;
        return false;
    }

    public void eat(int catSatiety) {
        System.out.println("Степень сытости " + name + " равна " + catSatiety);
        catSatiety++;
    }

    public void eat(int catSatiety, String nameFood) {
        System.out.println("Степень сытости " + name + " равна " + catSatiety + ", он ест " + nameFood);
        catSatiety++;
    }

    public void eat() {
        eat(catSatiety, "Вискас");
        System.out.println(name + " поел");
        catSatiety++;
    }

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    public Kotik() {

    }

    public static void setCount(int count) {
        Kotik.count = count;
    }

    public static int getCount() {
        return count;
    }

    public void setPrettiness(int prettiness) {
        this.prettiness = prettiness;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public String getMeow() {
        return meow;
    }
}
