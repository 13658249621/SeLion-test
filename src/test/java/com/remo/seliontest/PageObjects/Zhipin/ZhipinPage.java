package com.remo.seliontest.PageObjects.Zhipin;

public enum ZhipinPage {
    问意向("问意向", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/问意向.png"),
    我的订单("我的订单", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/我的订单.png"),
    发现("发现", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/发现.png"),
    首页("首页", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/首页.jpg"),
    推荐("推荐", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/推荐.jpg"),
    职位类型("职位类型", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/职位类型.png"),
    公司行业("公司行业", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/公司行业.png"),
    搜索按钮("搜索按钮", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/搜索.png"),
    搜索按("搜索按钮", "./src/test/resources/GUIData/TargetImage/Web/Zhipin/搜索.png");

    private final String elementName;
    private final String imagePath;

    ZhipinPage(String elementName, String imagePath) {
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