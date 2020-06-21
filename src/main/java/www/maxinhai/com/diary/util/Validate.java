package www.maxinhai.com.diary.util;

public class Validate {

    public static void execAssert(boolean isTrue, String message) throws RuntimeException {
        if (!isTrue) {
            throw new RuntimeException(message);
        }
    }

}
