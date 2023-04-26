package com.youkeda.application.ebusiness.model;

/**
 * @author 刘铭垚
 * @version 1.0
 */

/**
 *主键id可能是数字，也有字符串，使用泛型更方便；项目中其他模型都集成BaseID，即可拥有三个属性
 * @param <T>
 */
public class BaseID<T> extends BaseDate{
    //主键
    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
