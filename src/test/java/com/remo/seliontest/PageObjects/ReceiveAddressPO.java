package com.remo.seliontest.PageObjects;

public enum ReceiveAddressPO {
    添加地址("添加地址", "./src/test/resources/GUIData/TargetImage/App/添加地址.png");

    private final String elementName;
    private final String imagePath;

    ReceiveAddressPO(String elementName, String imagePath) {
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