package com.example.enroll.vo;

public class Reader extends Man implements Speakable {

    public Reader(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return this.getName() + " 독자는 자바를 잘하고 싶어 한다.";
    }
}
