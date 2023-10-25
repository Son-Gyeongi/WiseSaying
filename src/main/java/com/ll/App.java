package com.ll;

import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        // 표준 입력, 키보드
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("==명언 앱");
            System.out.print("명령 ) ");
            String cmd = scanner.nextLine();

            //        System.out.printf("입력하신 명령 : %s\n", cmd);
            System.out.printf("입력하신 명령어 : %s\n", cmd);

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String talk = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
            } else if (cmd.equals("종료")) {
                System.exit(0);
            }
        } while (true);
    }
}
