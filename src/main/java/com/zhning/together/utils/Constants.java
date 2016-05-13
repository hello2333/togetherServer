package com.zhning.together.utils;

/**
 * Created by baidu on 16/5/13.
 */
public class Constants {
    public static final int RECRUIT_FOOD = 1;
    public static final int RECRUIT_MOVIE = 2;
    public static final int RECRUIT_KTV = 3;

    public static final int CONSUME_AA = 1;
    public static final int CONSUME_MY = 2;
    public static final int CONSUME_OTHER = 3;

    public static final int RECRUIT_ING = 0;
    public static final int RECRUIT_FINISH = 1;

    public static final int APPLY_AGREE = 1;
    public static final int APPLY_DISAGREE = 0;

    public static final int SUCCESS = 1;
    public static final int NULL = 2;
    public static final int FAILED = 3;

    public enum Code {
        SUCCESS(200, "success"),
        ERROR(500, "sorry,wrong operation"),
        NULLDATA(300, "null data");
        private final int code;
        private final String message;

        private Code(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public int getCode() {
            return code;
        }

    }
}
