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
import www.maxinhai.com.diary.command.change.ModifyNoteCommand;
import www.maxinhai.com.diary.command.other.QueryDiaryCommand;
import www.maxinhai.com.diary.command.remove.DeleteNoteCommand;
import www.maxinhai.com.diary.domain.Diary;
import www.maxinhai.com.diary.domain.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/note")
@Api(value = "Note接口API", description = "便签接口API")
public class NoteController extends AbstractController {


    @ApiOperation(value = "Note Create", notes = "创建标签")
    @ApiImplicitParam(name = "command", value = "创建命令", dataType = "AddNoteCommand")
    @RequestMapping(value = "/createNote", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> createNote(@RequestBody AddNoteCommand command) {
        noteHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        result.put("data", null);
        return result;
    }


    @ApiOperation(value = "Note Change", notes = "修改标签")
    @ApiImplicitParam(name = "command", value = "修改命令", dataType = "ModifyNoteCommand")
    @RequestMapping(value = "/changeNote", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> changeNote(@RequestBody ModifyNoteCommand command) {
        noteHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Note Remove", notes = "删除标签")
    @ApiImplicitParam(name = "command", value = "删除命令", dataType = "DeleteNoteCommand")
    @RequestMapping(value = "/removeNote", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> removeNote(@RequestBody DeleteNoteCommand command) {
        noteHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Note Query", notes = "查询标签")
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
        List<Note> diaryList = mongoTemplate.find(query, Note.class);
        long count = mongoTemplate.count(query, Note.class);
        result.put("state", SUCCESS);
        result.put("code", SUCCESSCODE);
        result.put("data", diaryList);
        result.put("total", count);
        return result;
    }

}
