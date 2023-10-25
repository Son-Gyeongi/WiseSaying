package com.ll;

import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        int sequence = 0;
        System.out.println("==명언==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                scanner.nextLine();
                System.out.print("작가 : ");
                scanner.nextLine();
                System.out.println(++sequence + "번 명언이 등록되었습니다.");
            }
        }
    }
}
