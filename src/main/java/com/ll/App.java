package com.ll;

import java.util.Scanner;

public class App {

    void run() {
        Scanner scanner = new Scanner(System.in);
        int lastQuotationId = 0;
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                scanner.nextLine();
                System.out.print("작가 : ");
                scanner.nextLine();

                lastQuotationId++;
                int id = lastQuotationId;

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            }
        }
    }
}
