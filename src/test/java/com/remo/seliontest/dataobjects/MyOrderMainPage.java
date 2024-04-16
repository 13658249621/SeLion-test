package com.remo.seliontest.dataobjects;

public enum MyOrderMainPage {
    收货地址("收货地址", "./src/test/resources/GUIData/TargetImage/App/收货地址2.png"),
    更多工具("更多工具", "./src/test/resources/GUIData/TargetImage/App/更多工具.png"),
    收藏商品("收藏商品", "./src/test/resources/GUIData/TargetImage/App/收藏商品.png");

    private final String elementName;
    private final String imagePath;

    MyOrderMainPage(String elementName, String imagePath) {
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