package com.ll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 선언
        Scanner s = new Scanner(System.in); // 키보드에서 입력을 받을 수 있는 Scanner 객체를 하나 생성

        System.out.println("==명언 앱==");
        String str; // 입력값
        int sequence = 0;
        ArrayList arrayList = new ArrayList<>();

        do {
            System.out.print("명령 ) ");
            str = s.nextLine(); // 입력 받은 데이터 한 줄을 읽어서, String으로 리턴

            if (str.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = s.nextLine();
                System.out.print("작가 : ");
                String author = s.nextLine();
                System.out.println(++sequence + "번 명언이 등록되었습니다.");
                arrayList.add(sequence + " / " + author + " / " + wiseSaying);
            }
            if (str.equals("종료")) {
                System.exit(0);
            }

            if (str.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                Collections.reverse(arrayList);
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println(arrayList.get(i));
                }
            }
        } while (true);
    }
}