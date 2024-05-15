package com.remo.seliontest.PageObjects;

public enum AddAddressPO {
    保存("保存", "./src/test/resources/GUIData/TargetImage/App/保存.png"),
    详细地址("详细地址", "./src/test/resources/GUIData/TargetImage/App/详细地址.png"),
    长安区("长安区", "./src/test/resources/GUIData/TargetImage/App/长安区.png"),
    石家庄市("石家庄市", "./src/test/resources/GUIData/TargetImage/App/石家庄市.png"),
    河北省("河北省", "./src/test/resources/GUIData/TargetImage/App/河北省.png"),
    选择地区("选择地区", "./src/test/resources/GUIData/TargetImage/App/选择地区1.png"),
    收货人手机号("收货人手机号", "./src/test/resources/GUIData/TargetImage/App/收货人手机号1.png"),
    收货人姓名("收货人姓名", "./src/test/resources/GUIData/TargetImage/App/收货人姓名.png");

    private final String elementName;
    private final String imagePath;

    AddAddressPO(String elementName, String imagePath) {
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