package com.yeahbutstill.javavalidation.container;

// Data ini kita jadikan Generic
public class Data<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
