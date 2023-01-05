package com.example.enroll.vo;

public class Worker extends Man implements Speakable {

    public Worker(String name) {
        super(name);
    }

    @Override
    public String speak() {

        return this.getName() + " 일꾼은 자기가 맡은 일을 잘하고 싶어 한다.";
    }
}
