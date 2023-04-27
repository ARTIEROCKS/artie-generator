package artie.pedagogicalintervention.generator.enums;

public enum PrologResultsEnum {

    SINGLE("SINGLE"),
    MULTIPLE("MULTIPLE");

    private final String value;
    private PrologResultsEnum(String value) {
        this.value=value;
    }
    public String getValue() {
        return value;
    }
}
