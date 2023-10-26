package com.ll;

import java.util.ArrayList;
import java.util.List;

public class Rq {
    String cmd;
    String action;
    String queryString;
    List<String> paramNames;
    List<String> paramValues;

    Rq(String cmd) {
        paramNames = new ArrayList<>();
        paramValues = new ArrayList<>();

        this.cmd = cmd;

        // Bits 조각이라는 뜻
        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0];
        queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            paramNames.add(paramName);
            paramValues.add(paramValue);
        }
    }

    String getAction() {
        return action;
    }

    int getParamAsInt(String paramNmae, int defaultValue) {
        // paramNames에서 몇번째 인덱스인지 찾기, indexOf()는 찾는거다. 없으면 -1 반환
        int index = paramNames.indexOf(paramNmae);

        if (index == -1) return defaultValue;

        // 원하는 paramName 찾으면
        String paramValue = this.paramValues.get(index);

        // 고객이 잘못 입력해 실패할 수도 있다.
        // 위험한 일은 try-catch()문에 감싼다.
        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
