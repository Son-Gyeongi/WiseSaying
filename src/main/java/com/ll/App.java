package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그램 중심
public class App {

    Scanner scanner;
    int lastQuotationId;
    List<Quotation> quotations;

    App() {
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?")) {
                actionRemove(cmd);
            } else if (cmd.startsWith("수정?")) {
                actionModify(cmd);
            }
        }
    }

    void actionWrite() {
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
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        if (quotations.isEmpty()) { // 명언이 없다면
            System.out.println("등록된 명언이 없습니다.");
        }

        // 목록 내림차순으로 보여주기
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    void actionRemove(String cmd) { // 어떤걸 삭제? 매개변수 받아야 한다.

        // 나누고 싶은 문자열(cmd), 받고 싶은 paramName("id"), 없는 경우 반환을 0으로
        int id = getParamAsInt(cmd, "id", 0);

        // id값이 이상하거나 없을경우
        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; // 함수를 끝낸다.
        }

        System.out.printf("%d번 수정이 삭제되었습니다.\n", id);
    }

    void actionModify(String cmd) {
        int id = getParamAsInt(cmd, "id", 0);

        // id값이 이상하거나 없을경우
        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; // 함수를 끝낸다.
        }

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    int getParamAsInt(String cmd, String paramName, int defaultValue) {
        // Bits 조각이라는 뜻
        String[] cmdBits = cmd.split("\\?", 2);
        String queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];

            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String _paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            if (_paramName.equals(paramName)) {
                try {
                    // 문제가 없을 경우
                    return Integer.parseInt(paramValue);
                } catch (NumberFormatException e) {
                    // 문제가 생긴 경우
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }
}
