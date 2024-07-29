package org.choongang.global.validators;

public interface PasswordValidator { // 공통적인 validator
    /**
     * 알파벳 복잡성 체크
     *
     * @param password
     * @param caseIncensitive - false : 대소문자 각각 1개씩 이상 포함, true - 대소문자 구분 X
     * @return
     */
    default boolean alphaCheck(String password, boolean caseIncensitive) {
        if (caseIncensitive) { // 대소문자 구분없이 알파벳 체크
            return password.matches(".*[a-zA-Z]+.*]"); // 알파벳 대소문자 관계없이 1개 이상

        }
        return password.matches(".*[a-z]+.*") && password.matches(".*[A-Z]+.*");
    }

    /**
     * 숫자 복잡성 체크
     *
     * @param password
     * @return
     */
    default boolean numberChect(String password) {
         return password.matches(".*\\d+.*");

    }

    /**
     * 특수문자 복잡성 체크
     *
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password) { // \\ 꺽쇠는  ** 이 아닌 패턴
        String pattern = ".*[^0-9a-zA-Zㄱ-ㅎ가-힣]+.*";
        return password.matches(pattern);
    }
}
