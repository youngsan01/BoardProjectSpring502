package org.choongang.global.validators;

public interface MobilValidator {
    default boolean mobilCheck(String mobil) {
        /**
         * 01[016]-0000/000
         * 01[016]-\d{3,4}-\d{4}
         *  010.1111.1111
         *  010 1111 1111
         *  010-1111-1111
         *  01011111111
         *  1. 숫자만 남긴다. 2. 패턴 만들기 3.체크
         */

        mobil = mobil.replaceAll("\\D", "");
        String pattern = "01[016]\\d{3,4}\\d{4}";

        return mobil.matches(pattern);
    }
}
