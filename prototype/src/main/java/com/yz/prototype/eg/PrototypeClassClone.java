package com.yz.prototype.eg;

import java.util.ArrayList;

public class PrototypeClassClone implements Cloneable {
    private ArrayList<String> arrayList = new ArrayList<String>();

    /**
     * 覆写父类Object方法
     *
     * @return
     */
    @Override
    public PrototypeClassClone clone() {
        PrototypeClassClone prototypeClass = null;
        try {
            prototypeClass = (PrototypeClassClone) super.clone();
            prototypeClass.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            // 异常处理
        }
        return prototypeClass;
    }
}
