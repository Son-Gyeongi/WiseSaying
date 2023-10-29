package com.ll;

import java.util.Scanner;

public class App {

    void run() {
        System.out.println("==명언 앱==");
        System.out.println("명령) ");

        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();

        if (cmd.equals(" 종료")) {
            return;
        }
    }
}
