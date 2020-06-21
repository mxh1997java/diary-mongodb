package www.maxinhai.com.diary.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diary.command.add.AddUserCommand;
import www.maxinhai.com.diary.command.change.ModifyUserCommand;
import www.maxinhai.com.diary.command.other.CheckUserCommand;
import www.maxinhai.com.diary.command.remove.DeleteUserCommand;
import www.maxinhai.com.diary.domain.User;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.EncryptUtils;
import www.maxinhai.com.diary.util.Validate;
import java.util.Date;
import java.util.UUID;

/**
 * 用户处理器
 */
@Service
public class UserHandler extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserHandler.class);

    /**
     * 添加用户
     * @param command
     */
    public void handler(AddUserCommand command) {
        logger.info("创建用户: {}", command);
        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setUsername(command.getUsername());
        EncryptUtils instance = EncryptUtils.getInstance();
        user.setPassword(instance.MD5(command.getPassword(), KEY));
        user.setCreateTime(new Date());
        userRepository.save(user);
    }

    /**
     * 修改用户信息
     * @param command
     */
    public void handler(ModifyUserCommand command) {
        User user = getUser(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(user), command.getId() + "数据不存在!");
        user.setUsername(command.getUsername());
        EncryptUtils instance = EncryptUtils.getInstance();
        user.setPassword(instance.MD5(command.getPassword(), KEY));
        user.setModifyTime(new Date());
        userRepository.save(user);
    }


    /**
     * 删除用户信息
     * @param command
     */
    public void handler(DeleteUserCommand command) {
        User user = getUser(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(user), command.getId() + "数据不存在!");
        userRepository.delete(user);
    }


    /**
     * 校验用户名密码
     * @param command
     * @return
     * @throws RuntimeException
     */
    public boolean handler(CheckUserCommand command) throws RuntimeException {
        User user = userRepository.findByUsername(command.getName());
        Validate.execAssert(EmptyUtils.isEmpty(user), command.getName() + "用户不存在!");
        String password = user.getPassword();
        EncryptUtils instance = EncryptUtils.getInstance();
        String md5 = instance.MD5(command.getPassword(), KEY);
        if(!password.equals(md5)) {
            return false;
        }
        return true;
    }

}
