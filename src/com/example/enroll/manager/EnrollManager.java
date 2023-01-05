package com.example.enroll.manager;

import com.example.enroll.vo.Man;
import com.example.enroll.vo.Reader;
import com.example.enroll.vo.Speakable;
import com.example.enroll.vo.Worker;

public class EnrollManager {
    /** 지금 요구된 건 Speakable 객체들만 담음.
     * <h3>요구사항</h3>
     * <ul>
     *     <li>2명만 담음.</li>
     *     <li>변경/삭제 없이 '등록'만 있음.</li>
     * </ul>
     * */
//    private List<Speakable> speakableList; // -> 확장 고려한 설계
    private Speakable[] speakableList; // -> 확장 그딴 거 없이 노빠꾸 설계
    private int index; // 아무것도 안 주면 멤버변수는 기본값: 0, false, null, ...

    public EnrollManager() {
        super(); // 생략 가능
        this.speakableList = new Speakable[2];
        this.index = 0;
    }

    public boolean registerReader(String name) {
        // 유효성 체크: 더 이상 넣을 수 없을 때.
        if(index >= speakableList.length) return false;

        Speakable newMember = new Reader(name);
        speakableList[index] = newMember;
        index++;

        return true;
    }

    public boolean registerWorker(String name) {
        // 유효성 체크: 더 이상 넣을 수 없을 때.
        if(index >= speakableList.length) return false;

        Speakable newMember = new Worker(name);
        speakableList[index] = newMember;
        index++;

        return true;
    }

    public void speakAll() {
        for(Speakable speaker: speakableList) {
            String message = speaker.speak();
            System.out.println(message);
        }
    }

    public int getRest() {
        return speakableList.length - index;
    }
}
