package com.ll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner s = new Scanner(System.in);
    int quotationId = 0;
        List<Quotation> quotations = new ArrayList<>(); // 명언 모음
    List<Quotation> quotationList = new ArrayList<>(); // 파일에서 불러오는 명언 모음
    static final String folderPath = "C:/techitStudy/wiseSaying/fileSave/"; // 파일 불러올 경로

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

                // 삭제 로직
                deleteQuotation(cmd);
            } else if (cmd.startsWith("수정?")) {
                // 수정 로직
                updateQuotation(cmd);
            }
        } // break; 로 끝나는 지점
    }

    // 명언 등록
    void saveQuotation() {
        System.out.print("명언 : ");
        String content = s.nextLine();
        System.out.print("작가 : ");
        String authorName = s.nextLine();

        /*  -> 메모리가 아닌 파일에 저장해서 주석
        quotationId++;
        int id = quotationId;

        // 객체 생성
        Quotation quotation = new Quotation(id, authorName, content);
        // List에 넣어주기
        quotations.add(quotation);
         */

        // 파일에 저장
        try {
            FileWriter writer = new FileWriter(folderPath + authorName);
            writer.write(content);
            writer.close();
            System.out.println("파일이 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        System.out.println("파일 테스트 중");
//        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    // 명언 목록
    void listQuotation() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        // 파일 불러오기
        File folder = new File(folderPath);
        File[] files = folder.listFiles(); // file 제목들

        if (files != null) {
            for (File file : files) {
                // 객체 생성
                Quotation fileQuotation = new Quotation(quotationId, file.getName(), readContentFromFile(file));
                // List에 넣어주기
                quotationList.add(fileQuotation);
            }
        }

        for (int i = quotationList.size() - 1; i >= 0; i--) {
            // List에서 꺼내기
            Quotation quotation = quotationList.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.quotation);
        }

        quotationId++; // id가 까다롭군 ㅠㅠㅠㅠㅠ
    }

    // 파일 내용 읽어온다.
    private static String readContentFromFile(File file) {
        StringBuffer contentBuilder = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    // 명언 삭제
    void deleteQuotation(String cmd) {
        // 키보드 삭제 입력 시 id 추출, 삭제?id=1&archive=true
        int id = getParamAsInt(cmd, "id");

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return;
        }

        // id에 맞는 인덱스 구하기
        for (int i = 0; i < quotations.size(); i++) {
            Quotation quotation = quotations.get(i);
            if (quotation.id == id) {
                quotations.remove(i);
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                return; // 메서드를 아예 빠져나간다.
            }
        }

        // id 값이 없을 때, 존재하지 않는 id인 경우
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
    }

    // 명언 수정
    void updateQuotation(String cmd) {
        // 키보드 삭제 입력 시 id 추출, 삭제?id=1&archive=true
        int id = getParamAsInt(cmd, "id");

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return;
        }

        // 기존 명언 불러오기
        for (int i = 0; i < quotations.size(); i++) {
            Quotation quotation = quotations.get(i);
            if (quotation.id == id) {
                System.out.println("명언(기존) : " + quotation.quotation);
                System.out.print("명언 : ");
                String newQuotation = s.nextLine();
                System.out.println("작가(기존) : " + quotation.authorName);
                System.out.print("작가 : ");
                String newAuthorNmae = s.nextLine();

                // 명언에 새로운 값 넣기
                quotation.setQuotation(newQuotation);
                quotation.setAuthorName(newAuthorNmae);
                return; // 메서드를 아예 빠져나간다.
//                        break; // 반복문을 빠져나간다.
            }
        }

        // id 값이 없을 때, 존재하지 않는 id인 경우
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
    }

    // 키보드 삭제 입력 시 id 추출
    int getParamAsInt(String cmd, String paramName) {
        int id = 0; // id값
        int defaultValue = 0; // id값이 없을 경우

        List<String> _paramName = new ArrayList<>();
        List<String> paramValue = new ArrayList<>();

        try {
            // 삭제?id=1&archive=true 에서 1만 추출하기, Bits는 조각이라는 뜻
            String[] cmdBits = cmd.split("\\?", 2);
//        String action = cmdBits[0]; // 삭제
            String queryString = cmdBits[1]; // id=1&archive=true

            String[] queryStringBits = queryString.split("&");

            // '&'에서는 여러 개 나오니깐 for문으로
            for (int i = 0; i < queryStringBits.length; i++) {
                String[] param = queryStringBits[i].split("=", 2);
                _paramName.add(param[0]);
                paramValue.add(param[1]);
            }
        } catch (IndexOutOfBoundsException e) {
            return defaultValue;
        }

        // paramName에서 'id' 찾기
        for (int i = 0; i < _paramName.size(); i++) {
            try {
                if (_paramName.get(i).equals(paramName)) {
                    return Integer.parseInt(paramValue.get(i));
                }
            } catch (NumberFormatException e) {
                // return defaultValue; 밖에 있는 return이랑 같이 쓴다.
            }
        }

        return defaultValue;
    }
}
