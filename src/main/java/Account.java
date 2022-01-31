public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.matches("^(?=.{3,19}$)[А-Яа-яЕеЁёa-zA-Z]+\\s[А-Яа-яЕеЁёa-zA-Z]+$");
    }




}