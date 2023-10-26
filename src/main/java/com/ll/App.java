package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        int lastQuotationId = 0;
        System.out.println("==명언 앱==");

        List<Quotation> quotations = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String authorName = scanner.nextLine();

                lastQuotationId++;
                int id = lastQuotationId;

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);

                // Qutotation 생성자로 초기화하고 객체 만들기
                Quotation quotation = new Quotation(id, content, authorName);
                quotations.add(quotation);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                // 목록 내림차순으로 보여주기
                for (int i = quotations.size() - 1; i >= 0; i--) {
                    Quotation quotation = quotations.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
                }
            }
        }
    }
}
