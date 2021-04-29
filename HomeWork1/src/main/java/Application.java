import model.Kotik;

public class Application {
    public static void main(String[] args) {

        Kotik kotik = new Kotik(5, "Барсик", 5, "Мяу-мяу");
        Kotik.getCount();


        Kotik kotik1 = new Kotik();
        Kotik.getCount();
        kotik1.setPrettiness(3);
        kotik1.setName("Васька");
        kotik1.setWeight(7);
        kotik1.setMeow("Мяу-мяу-мяу");
        kotik1.liveAnotherDay();

        System.out.println("Котика зовут " + kotik1.getName() + ", его вес " + kotik1.getWeight());
        System.out.println(kotik.getMeow().equals(kotik1.getMeow()));
        System.out.println("Количество котиков: " + Kotik.getCount());
    }
}
