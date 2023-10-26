package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그램 중심
public class App {
    void run() {
        int sequence = 0;
        List<String> list = new ArrayList<>(); // 명언 목록
        System.out.println("==명언==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String saying = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                System.out.println(++sequence + "번 명언이 등록되었습니다.");
                String str = sequence + " / " + author + " / " + saying;
                list.add(str);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                // 목록 내림차순으로 보여주기
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get((list.size()-1) - i));
                }
            } else if (cmd.equals("삭제?id=")) {
                String deleteNum = scanner.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    String listNum = list.get(i).substring(0,1);

                    if (deleteNum.equals(listNum)) {
                        list.remove(i);
                        System.out.println(listNum + "번 명언이 삭제되었습니다.");
                    }
                }
            }
        }
    }
}
