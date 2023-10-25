package com.ll;

import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        System.out.println("==명언==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
