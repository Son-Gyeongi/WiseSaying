package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    List<String> paramNames = new ArrayList<>();
    List<String> paramValues = new ArrayList<>();

    void run() {
        Scanner scanner = new Scanner(System.in);
        int lastQuotationId = 0;
        List<Quotation> list = new ArrayList<>();

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
                // parmaName "id"의 paramValue를 반환
                int id = getParamAsInt(cmd, "id");
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
            }
        }
    }

    // 입력 받은 queryString에서 paramNames, paramValues 나누기
    int getParamAsInt(String cmd, String paramName) {
        int defaultValue = 0; // 값이 없을 경우 반환값

        String[] cmdBits = cmd.split("\\?", 2);
//        String action = cmdBits[0];
        String queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String[] paramBits = queryStringBits[i].split("=", 2);

            String _paramName = paramBits[0];
            String paramValue = paramBits[1];

            paramNames.add(_paramName);
            paramValues.add(paramValue);
        }
        for (int i = 0; i < paramNames.size(); i++) {
            if (paramNames.get(i).equals(paramName)) {
                String index = paramValues.get(i);
                 return Integer.parseInt(index);
            }
        }
        return defaultValue;
    }
}
