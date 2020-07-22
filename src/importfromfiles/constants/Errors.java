package importfromfiles.constants;

public enum Errors {

    WRITE_TO_FILE_ERROR ("Bład podczas zapisu do pliku."),
    FILE_NOT_FOUND ("Plik nie został znaleziony");

    String value;

    Errors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
