package com.example.enroll.ui;

import com.example.enroll.manager.EnrollManager;
import com.example.enroll.util.CustomScanner;

public class EnrollUi {

    private final static String HOME = "HOME";
    private final static String ADD_READER = "ADD_READER";
    private final static String ADD_WORKER = "ADD_WORKER";
    private final static String QUIT = "QUIT";

    private final CustomScanner scanner = new CustomScanner();
    private final EnrollManager manager = new EnrollManager();
    private String cursor = HOME;

    public void run() {
        mainLoop: while(manager.getRest() > 0) {
            switch (cursor) {
                case HOME:
                    home();
                    break;
                case ADD_READER:
                    registerReader();
                    break;
                case ADD_WORKER:
                    registerWorker();
                    break;
                case QUIT:
                    System.out.println("UI를 종료합니다.");
                    return;
                default:
                    // cursor가 우리가 원한 상태가 아닐 때 실행되는 곳.
                    this.cursor = HOME;
                    break;
            }
        }// END::mainLoop

        // 이것도 메뉴로 해도 됨.
        System.out.println("두 명 Speaker의 등록이 완료되었습니다. 이제 Speaker들의 speak 실행 결과입니다.");
        manager.speakAll();
    }

    private void home() {
        System.out.println("=== Home ===");
        System.out.println("Speaker 등록 메인 메뉴입니다. 단 2명만 등록할 수 있습니다.");
        System.out.println("어떤 Speaker를 등록하는지 선택하세요.");
        System.out.println(" 1. Reader 등록");
        System.out.println(" 2. Worker 등록");
        System.out.println(" 0. 종료");
        System.out.print(" > ");

        int sel = scanner.nextInt();

        switch (sel) {
            case 1:
                this.cursor = ADD_READER;
                break;
            case 2:
                this.cursor = ADD_WORKER;
                break;
            case 0:
                this.cursor = QUIT;
                // 또는 System.exit(0); // 0: 정상, 그 외는 에러코드, -1: 안 정한 에러코드(주로)
                break;
            default:
                this.cursor = HOME;
                break;
        }
    }

    private void registerReader() {
        int rest = manager.getRest();
        System.out.println("=== Reader 등록 메뉴 ===");
        System.out.println("Reader를 등록합니다.(잔여 등록 가능 수: " + rest + ")");
        System.out.println("이름을 입력하세요.");
        System.out.print(" > ");

        String name = scanner.nextLine();
        if("".equals(name)) {
            // . => ~의
            // name.equals() => name의 equals 메서드
            // null.머시기 => null은 아무것도 가지지 못함.
            // NPE(NullPointerException) 발생할 수 있음.
            this.cursor = ADD_READER; // 의미상으로만 작성. 이곳으로 다시 온다는 것.
            return;
        }

        // Create Reader
        manager.registerReader(name);
        this.cursor = HOME; // HOME으로 안 보내면 => 다시 여기로 옴(무한루프처럼 됨.).
        return;
    }

    private void registerWorker() {
        int rest = manager.getRest();
        System.out.println("=== Worker 등록 메뉴 ===");
        System.out.println("Worker를 등록합니다.(잔여 등록 가능 수: " + rest + ")");
        System.out.println("이름을 입력하세요.");
        System.out.print(" > ");

        String name = scanner.nextLine();
        if("".equals(name)) {
            // . => ~의
            // name.equals() => name의 equals 메서드
            // null.머시기 => null은 아무것도 가지지 못함.
            // NPE(NullPointerException) 발생할 수 있음.
            this.cursor = ADD_WORKER; // 의미상으로만 작성. 이곳으로 다시 온다는 것.
            return;
        }

        // Create Reader
        manager.registerWorker(name);
        this.cursor = HOME; // HOME으로 안 보내면 => 다시 여기로 옴(무한루프처럼 됨.).
        return;
    }
}
