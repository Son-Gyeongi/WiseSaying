package com.ll;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            Scanner s = new Scanner(System.in);
            String cmd = s.nextLine();

            if (cmd.equals("종료")) {
                break; // 반복문 종료
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                s.nextLine();
                System.out.print("작가 : ");
                s.nextLine();
            }
        } // break; 로 끝나는 지점
    }
}
