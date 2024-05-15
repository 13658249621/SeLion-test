package com.remo.seliontest.PageObjects;

public enum WeiboMainPO {
    我的("我的", "./src/test/resources/GUIData/TargetImage/App/我的.png");
    private final String elementName;
    private final String imagePath;
    WeiboMainPO(String elementName, String imagePath) {
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