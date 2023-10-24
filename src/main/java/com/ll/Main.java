package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 선언
        Scanner s = new Scanner(System.in); // 키보드에서 입력을 받을 수 있는 Scanner 객체를 하나 생성

        System.out.println("==명언 앱==");
        String str; // 입력값

        do {
            System.out.print("명령 ) ");
            str = s.nextLine(); // 입력 받은 데이터 한 줄을 읽어서, String으로 리턴

            if (str.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = s.nextLine();
                System.out.print("작가 : ");
                String author = s.nextLine();
                System.out.println("1번 명언이 등록되었습니다.");
            }
            if (str.equals("종료")) {
                System.exit(0);
            }

        } while (true);
    }
}