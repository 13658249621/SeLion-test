package com.remo.seliontest.PageObjects;

public enum CollectItemPO {
    去逛逛("收藏商品", "./src/test/resources/GUIData/TargetImage/App/去逛逛.png");

    private final String elementName;
    private final String imagePath;

    CollectItemPO(String elementName, String imagePath) {
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