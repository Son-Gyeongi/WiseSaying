package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    void run() {
        Scanner scanner = new Scanner(System.in);
        int lastQuotationId = 0;
        List<Quotation> quotations = new ArrayList<>();

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
                quotations.add(quotation);

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                if (quotations.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                }

                for (int i = quotations.size() - 1; i >= 0; i--) {
                    Quotation quotation = quotations.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
                }
            } else if (cmd.startsWith("삭제?")) {
                // parmaName "id"의 paramValue를 반환
                int id = getParamAsInt(cmd, "id");

                // 삭제 로직
                if (id == 0) {
                    System.out.println("id를 정확히 입력해주세요.");
//                    return; // 함수를 끝낸다.
                    continue;
                }

                for (int i = 0; i < quotations.size(); i++) {
                    int quotationId = quotations.get(i).id;
                    if (id == quotationId) {
                        quotations.remove(i);
                        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                        return;
                    }
                }
            }
        }
    }

    // 입력 받은 queryString에서 paramNames, paramValues 나누기
    int getParamAsInt(String cmd, String paramName) {
        int defaultValue = 0; // 값이 없을 경우 반환값
        List<String> paramNames = new ArrayList<>();
        List<String> paramValues = new ArrayList<>();

        String[] cmdBits = cmd.split("\\?", 2);
//        String action = cmdBits[0];
        String queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");

        for (String queryStringBit : queryStringBits) { // 향상된 for문 (int i = 0; i < queryStringBits.length; i++)
            String[] paramBits = queryStringBit.split("=", 2);

            String _paramName = paramBits[0];
            String paramValue = paramBits[1];

            paramNames.add(_paramName);
            paramValues.add(paramValue);
        }
        for (int i = 0; i < paramNames.size(); i++) {
            if (paramNames.get(i).equals(paramName)) {
                try {
                    String index = paramValues.get(i);
                    return Integer.parseInt(index);
                } catch (NumberFormatException e) {
                    // 오류를 잡고 retrun defaultValue로 넘어간다.
                }
            }
        }
        return defaultValue;
    }
}
