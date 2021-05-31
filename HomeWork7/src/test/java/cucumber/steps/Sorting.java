package cucumber.steps;

public enum Sorting {

    По_умолчанию("По умолчанию"),
    Дешевле("Дешевле"),
    Дороже("Дороже"),
    По_дате("По дате");

    public String value;

    public String getValue() {
        return value;
    }

    Sorting(String value) {
        this.value = value;
    }
}
