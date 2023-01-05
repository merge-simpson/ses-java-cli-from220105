package com.example.enroll.util;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomScanner {
    // 위임(Delegation): 상속까진 아닌 관계. 위임으로 필요 기능만 이용.(이 경우는 상속이 안 되는 Scanner 클래스)
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public CustomScanner(Readable source) {
        this.scanner = new Scanner(source);
    }

    public CustomScanner(InputStream source) {
        this.scanner = new Scanner(source);
    }

    public int nextInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요.");
                System.out.print("> ");
            } finally {
                // flush buffer
                scanner.nextLine();
            }
        }
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
