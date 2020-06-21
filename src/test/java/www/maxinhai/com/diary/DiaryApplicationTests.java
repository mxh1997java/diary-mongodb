package www.maxinhai.com.diary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import www.maxinhai.com.diary.domain.User;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaryApplicationTests {

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void contextLoads() {

        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setUsername("maxinhai");
        user.setPassword("maxinhai");
        redisTemplate.opsForValue().set("mxh", user);

    }

}
