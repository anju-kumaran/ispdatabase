package co.demo.isp.drivermanager;

public enum  BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    SAFARI("safari"),
    EDGE("edge"),
    OPERA("opera");

    private String stringVal;

    BrowserType(String str) {
        this.stringVal = str;
    }

    @Override
    public String toString() {
        return this.stringVal;
    }

}

