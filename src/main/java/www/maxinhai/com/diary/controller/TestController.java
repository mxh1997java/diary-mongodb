package www.maxinhai.com.diary.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.maxinhai.com.diary.config.annotation.UserLoginToken;
import www.maxinhai.com.diary.domain.User;
import www.maxinhai.com.diary.repository.UserRepository;

@RestController
public class TestController {

    @GetMapping("/test01")
    public String test01() {
        return "不需要token";
    }

    @UserLoginToken
    @GetMapping("/test02")
    public String test02() {
        return "需要token";
    }

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping("/login")
    public Object login(@ApiParam(value = "账号") @RequestParam String account,
                        @ApiParam(value = "密码") @RequestParam String password) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userRepository.findByUsername(account);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(password)) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    public static String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getUserId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
