package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    void run() {
        Scanner scanner = new Scanner(System.in);
        int lastQuotationId = 0;
        List<Quotation> list = new ArrayList<>();
        List<String> paramNames = new ArrayList<>();
        List<String> paramValues = new ArrayList<>();
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
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

                // 명언을 다뤄 줄 객체 생성
                Quotation quotation = new Quotation(id, authorName, content);
                list.add(quotation);

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = list.size() - 1; i >= 0; i--) {
                    Quotation quotation = list.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
                }
            } else if (cmd.startsWith("삭제?")) {
                String[] cmdBits = cmd.split("\\?", 2);
                String action = cmdBits[0];
                String queryString = cmdBits[1];

                String[] queryStringBits = queryString.split("&");

                for (int i = 0; i < queryStringBits.length; i++) {
                    String[] paramBits = queryStringBits[i].split("=", 2);

                    String paramName = paramBits[0];
                    String paramValue = paramBits[1];

                    paramNames.add(paramName);
                    paramValues.add(paramValue);
                }

                int id = 0;

                for (int i = 0; i < paramNames.size(); i++) {
                    if (paramNames.get(i).equals("id")) {
                        String index = paramValues.get(i);
                        id = Integer.parseInt(index);
                    }
                }
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
            }
        }
    }
}
