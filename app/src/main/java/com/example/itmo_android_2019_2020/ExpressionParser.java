package com.example.itmo_android_2019_2020;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParser {

        private String expression;
        private int index;

        private Double val;
        private int flag;

        private Token curToken;

        ExpressionParser() {
            index = 0;
            expression = "";
        }

        private enum Token {
            PLUS,
            OPEN_BRACKET,
            CLOSE_BRACKET,
            MINUS,
            MUL,
            DIV,
            END,
            FAIL,
            CONST
        }

        private static Map<Character, Token> tokenMap = new HashMap<>();

        static {
            tokenMap.put('+', Token.PLUS);
            tokenMap.put('-', Token.MINUS);
            tokenMap.put('/', Token.DIV);
            tokenMap.put('*', Token.MUL);
            tokenMap.put('(', Token.OPEN_BRACKET);
            tokenMap.put(')', Token.CLOSE_BRACKET);
        }


        public CommonExpression parse(String str) {
            expression = str;
            index = 0;
            curToken = Token.FAIL;
            while (index < expression.length() && curToken == Token.FAIL) {
                curToken = getToken();
            }
            if (curToken == Token.END) {
                return new Const(0.0);
            }
            return addSub(false);
        }


        private Token getToken() {
            if (index >= expression.length()) {
                return Token.END;
            }

            char ch = expression.charAt(index++);

            if (tokenMap.containsKey(ch)) {
                return tokenMap.get(ch);
            }

            if (Character.isDigit(ch)) {
                Double c = getConst();
                if (c == null){
                    return Token.END;
                }
                val = c;
                return Token.CONST;
            }
            return Token.FAIL;
        }

        private boolean isCorrectConst(){
            if (flag < 2) {
                if (Character.isDigit(expression.charAt(index))){
                    return true;
                }
                if (expression.charAt(index) == '.') {
                    flag += 1;
                    return true;
                }
            }
            return false;
        }

        private Double getConst() {
            flag = 0;
            int start = index - 1;
            while (index < expression.length() && isCorrectConst()) {
                index++;
            }
            if (flag >= 2){
                return null;
            }
            return Double.parseDouble(expression.substring(start, index));
        }


        private CommonExpression addSub(boolean newToken) {
            CommonExpression left = mulDiv(newToken);

            while (true) {
                if (curToken == Token.PLUS) {
                    left = new Add(left, mulDiv(true));
                } else if (curToken == Token.MINUS) {
                    left = new Subtract(left, mulDiv(true));
                } else {
                    return left;
                }
            }
        }

        private CommonExpression mulDiv(boolean newToken) {
            CommonExpression left = primary(newToken);

            while (true) {
                if (curToken == Token.MUL) {
                    left = new Multiply(left, primary(true));
                } else if (curToken == Token.DIV) {
                    left = new Divide(left, primary(true));
                } else {
                    return left;
                }
            }
        }

        private CommonExpression primary(boolean newToken) {
            if (newToken) {
                curToken = getToken();
            }

            switch (curToken) {
                case CONST:
                    Double v = val;
                    curToken = getToken();
                    return new Const(v);
                case MINUS:
                    return new Neg(primary(true));
                case OPEN_BRACKET:
                    CommonExpression e = addSub(true);
                    if (curToken == Token.CLOSE_BRACKET) {
                        curToken = getToken();
                    }
                    return e;
                default:
                    return new Const(0.0);
            }
        }
}
