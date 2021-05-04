package model;

public class Kotik {
    private String name, nameFood, meow;
    private int weight, prettiness;
    private int catSatiety = 22;
    private static int count = 0;

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        count++;
    }

    public Kotik() {
        count++;
    }

    public void liveAnotherDay() {
        int rnd;
        int H = 5;
        for (int i = 0; i < 24; i++) {
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
        boolean b = false;
        if (catSatiety <= 0) {
            return b;
        }
        if (false) {
            System.out.println(name + " хочет есть");
            eat();
        } else {
            System.out.println(name + " поиграл с клубком");
            catSatiety--;
        }
        return true;
    }

    public boolean sleep() {
        if (catSatiety <= 0) {
            return false;
        }
        if (false) {
            System.out.println(name + " хочет есть");
            eat();
        } else {
            System.out.println(name + " поспал на кровати");
            catSatiety--;
        }
        return true;
    }

    public boolean chaseMouse() {
        if (catSatiety <= 0) {
            return false;
        }
        if (false) {
            System.out.println(name + " хочет есть");
            eat();
        } else {
            System.out.println(name + " поймал мышь");
            catSatiety--;
        }
        return true;
    }

    public boolean walk() {
        if (catSatiety <= 0) {
            return false;
        }
        if (false) {
            System.out.println(name + " хочет есть");
            eat();
        } else {
            System.out.println(name + " погулял на улице");
            catSatiety--;
        }
        return true;
    }

    public boolean jump() {
        if (catSatiety <= 0) {
            return false;
        }
        if (false) {
            System.out.println(name + " хочет есть");
            eat();
        } else {
            System.out.println(name + " попрыгал на диван");
            catSatiety--;
        }
        return true;
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
