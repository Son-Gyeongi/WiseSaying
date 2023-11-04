package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner s = new Scanner(System.in);
    int quotationId = 0;
    List<Quotation> quotations = new ArrayList<>();

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            String cmd = s.nextLine();

            if (cmd.equals("종료")) {
                break; // 반복문 종료
            } else if (cmd.equals("등록")) {
                saveQuotation();
            } else if (cmd.equals("목록")) {
                listQuotation();
            }
        } // break; 로 끝나는 지점
    }

    // 명언 등록
    void saveQuotation() {
        System.out.print("명언 : ");
        String content = s.nextLine();
        System.out.print("작가 : ");
        String authorName = s.nextLine();

        quotationId++;
        int id = quotationId;

        // 객체 생성
        Quotation quotation = new Quotation(id, authorName, content);
        // List에 넣어주기
        quotations.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    // 명언 목록
    void listQuotation() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = quotations.size() - 1; i >= 0; i--) {
            // List에서 꺼내기
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.quotation);
        }
    }
}
