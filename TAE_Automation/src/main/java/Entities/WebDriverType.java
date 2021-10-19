package Entities;

public enum WebDriverType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");
    private String type;
    WebDriverType(String type){
        this.type = type;
    }

    public String getDriverName() {
        return type;
    }
}
