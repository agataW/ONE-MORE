package pl.wujko.one_more.code.constance;

/**
 * Created by Agata on 2015-05-21.
 */
public enum TableEnum {
    TOPPING("topping"),
    ADDITION("addition");

    private String name;

    TableEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
