package com.example.enroll.manager;

import com.example.enroll.vo.Man;
import com.example.enroll.vo.Reader;
import com.example.enroll.vo.Speakable;
import com.example.enroll.vo.Worker;

import java.util.ArrayList;
import java.util.List;

public class EnrollManager {
    /** 지금 요구된 건 Speakable 객체들만 담음.
     * <h3>요구사항</h3>
     * <ul>
     *     <li>2명만 담음.</li>
     *     <li>변경/삭제 없이 '등록'만 있음.</li>
     * </ul>
     * */
    private List<Speakable> speakableList; // -> 확장 고려한 설계
    private final int limitSeat;

    public EnrollManager() {
        super(); // 생략 가능
        this.speakableList = new ArrayList<>(2); // 메모리 2칸만 할당하고 시작
        this.limitSeat = 2;
    }

    public EnrollManager(int limitSeat) {
        this.speakableList = new ArrayList<>(limitSeat);
        this.limitSeat = limitSeat;
    }

    public boolean registerReader(String name) {
        // 유효성 체크: 더 이상 넣을 수 없을 때.
        if(speakableList.size() > this.limitSeat) return false;

        Speakable newMember = new Reader(name);
        speakableList.add(newMember);
//        speakableList[index] = newMember;
//        index++;

        return true;
    }

    public boolean registerWorker(String name) {
        // 유효성 체크: 더 이상 넣을 수 없을 때.
        if(speakableList.size() > this.limitSeat) return false;

        Speakable newMember = new Worker(name);
        speakableList.add(newMember);

        return true;
    }

    public void speakAll() {
        for(Speakable speaker: speakableList) {
            String message = speaker.speak();
            System.out.println(message);
        }
    }

    public int getRest() {
        return this.limitSeat - speakableList.size();
    }
}
