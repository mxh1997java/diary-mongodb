package www.maxinhai.com.diary.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultBean {

    private String code;

    private String msg;

    private String name;

    public ResultBean(String name, String msg, String code) {
        this.code = code;
        this.msg = msg;
        this.name = name;
    }

}
