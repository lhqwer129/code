package com.pattern.pattern.builder;

/**
 * Description: 具体建造者，实现建造者定义的方法
 *
 * @author lihui
 * @time 2021/5/24 8:10 下午
 */
public class TextBuilder extends Builder {

    private final StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void makeTitle(java.lang.String title) {
        stringBuffer.append("==============================\n");
        stringBuffer.append("[").append(title).append("]\n");
        stringBuffer.append("\n");
    }

    @Override
    public void makeString(java.lang.String str) {
        stringBuffer.append('{' + str + "\n");
        stringBuffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            stringBuffer.append("" + items[i] + "\n");
        }
        stringBuffer.append("\n");
    }

    @Override
    public void close() {
        stringBuffer.append("===============\n");
    }

    public String getResult() {
        return stringBuffer.toString();
    }
}
