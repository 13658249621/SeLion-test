package com.remo.seliontest.dataobjects;

public enum WeiboMainPage {
    我的("我的", "./src/test/resources/GUIData/TargetImage/App/我的.png");
    private final String elementName;
    private final String imagePath;
    WeiboMainPage(String elementName, String imagePath) {
        this.elementName = elementName;
        this.imagePath = imagePath;
    }

    public String getElementName() {
        return elementName;
    }

    public String getImagePath() {
        return imagePath;
    }
}