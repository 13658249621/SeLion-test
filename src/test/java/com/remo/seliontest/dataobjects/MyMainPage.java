package com.remo.seliontest.dataobjects;

public enum MyMainPage {
    我的订单("我的订单", "./src/test/resources/GUIData/TargetImage/App/我的订单.png");

    private final String elementName;
    private final String imagePath;

    MyMainPage(String elementName, String imagePath) {
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