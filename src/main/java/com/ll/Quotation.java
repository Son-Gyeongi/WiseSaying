package com.ll;

// 명언 데이터를 담을 클래스
public class Quotation {
    int id;
    String authorName;
    String content;

    public Quotation(int id, String authorName, String content) {
        this.id = id;
        this.authorName = authorName;
        this.content = content;
    }
}
