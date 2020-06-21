package www.maxinhai.com.diary.command.other;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.domain.BaseEntity;

public class CheckUserCommand extends BaseEntity {

    @Setter
    @Getter
    private String password;

}
