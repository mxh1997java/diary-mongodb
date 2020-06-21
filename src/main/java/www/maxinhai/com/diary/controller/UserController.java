package www.maxinhai.com.diary.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import www.maxinhai.com.diary.command.add.AddNoteCommand;
import www.maxinhai.com.diary.command.add.AddUserCommand;
import www.maxinhai.com.diary.command.change.ModifyNoteCommand;
import www.maxinhai.com.diary.command.change.ModifyUserCommand;
import www.maxinhai.com.diary.command.other.QueryDiaryCommand;
import www.maxinhai.com.diary.command.remove.DeleteNoteCommand;
import www.maxinhai.com.diary.command.remove.DeleteUserCommand;
import www.maxinhai.com.diary.domain.Diary;
import www.maxinhai.com.diary.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "User接口API", description = "用户接口API")
public class UserController extends AbstractController {


    @ApiOperation(value = "User Create", notes = "创建用户")
    @ApiImplicitParam(name = "command", value = "创建命令", dataType = "AddUserCommand")
    @RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> createUser(@RequestBody AddUserCommand command) {
        userHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        result.put("data", null);
        return result;
    }


    @ApiOperation(value = "User Change", notes = "修改用户")
    @ApiImplicitParam(name = "command", value = "修改命令", dataType = "ModifyUserCommand")
    @RequestMapping(value = "/changeUser", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> changeUser(@RequestBody ModifyUserCommand command) {
        userHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "User Remove", notes = "删除用户")
    @ApiImplicitParam(name = "command", value = "删除命令", dataType = "DeleteUserCommand")
    @RequestMapping(value = "/removeUser", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> removeUser(@RequestBody DeleteUserCommand command) {
        userHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }

    @ApiOperation(value = "User Query", notes = "查询用户")
    @ApiImplicitParam(name = "command", value = "查询命令", dataType = "QueryDiaryCommand")
    @RequestMapping(value = "/queryData", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> queryData(@RequestBody QueryDiaryCommand command) {
        Map<String, Object> result = new HashMap<>(4);
        Query query = new Query();
        //条件
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.where("name").is(""));
        //排序
        List<Sort.Order> orders = new ArrayList<>();
        Sort sort = new Sort(orders);
        query.with(sort);
        //分页查询
        Pageable pageable = PageRequest.of(1-1, 10);
        query.with(pageable);
        List<User> diaryList = mongoTemplate.find(query, User.class);
        long count = mongoTemplate.count(query, User.class);
        result.put("state", SUCCESS);
        result.put("code", SUCCESSCODE);
        result.put("data", diaryList);
        result.put("total", count);
        return result;
    }

}
