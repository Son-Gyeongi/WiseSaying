package com.ll;

// 클래스를 생성해서 공통적이지 않은 것들을 묶어준다.
public class Quotation {
    int id; // 명언 번호
    String authorName; // 작가
    String quotation; // 명언

    public Quotation(int id, String authorName, String quotation) {
        this.id = id;
        this.authorName = authorName;
        this.quotation = quotation;
    }
}
