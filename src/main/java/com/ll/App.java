package com.ll;

import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령 ) ");
            // 표준 입력, 키보드
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break; // 반복문 종료
            }

            System.out.printf("입력하신 명령어 : %s\n", cmd);
        }
    }
}
