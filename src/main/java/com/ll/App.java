package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner s = new Scanner(System.in);
    int quotationId = 0;
    List<Quotation> quotations = new ArrayList<>(); // 명언 모음

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
            } else if (cmd.startsWith("삭제?")) {
                // startsWith() 괄호안에 시작하는 단어면 통과

                int id =0;

                List<String> paramName = new ArrayList<>();
                List<String> paramValue = new ArrayList<>();

                // 삭제?id=1&archive=true 에서 1만 추출하기, Bits는 조각이라는 뜻
                String[] cmdBits = cmd.split("\\?", 2);
                String action = cmdBits[0]; // 삭제
                String queryString = cmdBits[1]; // id=1&archive=true

                String[] queryStringBits = queryString.split("&");

                // '&'에서는 여러 개 나오니깐 for문으로
                for (int i = 0; i < queryStringBits.length; i++) {
                    String[] param = queryStringBits[i].split("=", 2);
                    paramName.add(param[0]);
                    paramValue.add(param[1]);
                }

                // paramName에서 'id' 찾기
                for (int i = 0; i < paramName.size(); i++) {
                    if (paramName.get(i).equals("id")) {
                        id = Integer.parseInt(paramValue.get(i));
                        break;
                    }
                }

                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
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
