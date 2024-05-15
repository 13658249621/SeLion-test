package com.remo.seliontest.PageObjects;

public enum MyMainPO {
    我的订单("我的订单", "./src/test/resources/GUIData/TargetImage/App/我的订单.png");

    private final String elementName;
    private final String imagePath;

    MyMainPO(String elementName, String imagePath) {
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