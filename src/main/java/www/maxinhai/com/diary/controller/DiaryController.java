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
import www.maxinhai.com.diary.command.add.AddDiaryCommand;
import www.maxinhai.com.diary.command.change.ModifyDiaryCommand;
import www.maxinhai.com.diary.command.other.QueryDiaryCommand;
import www.maxinhai.com.diary.command.remove.DeleteDiaryCommand;
import www.maxinhai.com.diary.domain.Diary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
@Api(value = "Diary接口API", description = "日记接口API")
public class DiaryController extends AbstractController {


    @ApiOperation(value = "Diary Create", notes = "创建日记")
    @ApiImplicitParam(name = "command", value = "创建命令", dataType = "AddDiaryCommand")
    @RequestMapping(value = "/createDiary", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> createDiary(@RequestBody AddDiaryCommand command) {
        diaryHandler.handler(command);
        Diary diary = getDiary(command.getAuthorId());
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        result.put("data", diary);
        return result;
    }


    @ApiOperation(value = "Diary Change", notes = "修改日记")
    @ApiImplicitParam(name = "command", value = "修改命令", dataType = "ModifyDiaryCommand")
    @RequestMapping(value = "/changeDiary", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> changeDiary(@RequestBody ModifyDiaryCommand command) {
        diaryHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Diary Remove", notes = "删除日记")
    @ApiImplicitParam(name = "command", value = "删除命令", dataType = "DeleteDiaryCommand")
    @RequestMapping(value = "/removeDiary", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> removeDiary(@RequestBody DeleteDiaryCommand command) {
        diaryHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }

    @ApiOperation(value = "Query Change", notes = "查询日记")
    @ApiImplicitParam(name = "command", value = "查询命令", dataType = "QueryDiaryCommand")
    @RequestMapping(value = "/queryData", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> queryData(@RequestBody QueryDiaryCommand command) {
        Map<String, Object> result = new HashMap<>(4);
        Query query = new Query();
        //条件
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.where("name").is(command.getName()));
        //排序
        List<Sort.Order> orders = new ArrayList<>();
        Sort sort = new Sort(orders);
        query.with(sort);
        //分页查询
        Pageable pageable = PageRequest.of(1-1, 10);
        query.with(pageable);
        List<Diary> diaryList = mongoTemplate.find(query, Diary.class);
        long count = mongoTemplate.count(query, Diary.class);
        result.put("state", SUCCESS);
        result.put("code", SUCCESSCODE);
        result.put("data", diaryList);
        result.put("total", count);
        return result;
    }

}
