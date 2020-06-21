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
import www.maxinhai.com.diary.command.add.AddLabelCommand;
import www.maxinhai.com.diary.command.change.ModifyLabelCommand;
import www.maxinhai.com.diary.command.other.QueryDiaryCommand;
import www.maxinhai.com.diary.command.other.QueryLabelCommand;
import www.maxinhai.com.diary.command.remove.DeleteLabelCommand;
import www.maxinhai.com.diary.domain.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/label")
@Api(value = "Label接口API", description = "标签接口API")
public class LabelController extends AbstractController {


    @ApiOperation(value = "Label Create", notes = "创建标签")
    @ApiImplicitParam(name = "command", value = "创建命令", dataType = "AddLabelCommand")
    @RequestMapping(value = "/createLabel", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> createLabel(@RequestBody AddLabelCommand command) {
        labelHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        result.put("data", null);
        return result;
    }


    @ApiOperation(value = "Label Change", notes = "修改标签")
    @ApiImplicitParam(name = "command", value = "修改命令", dataType = "ModifyLabelCommand")
    @RequestMapping(value = "/changeLabel", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> changeLabel(@RequestBody ModifyLabelCommand command) {
        labelHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Label Remove", notes = "删除标签")
    @ApiImplicitParam(name = "command", value = "删除命令", dataType = "DeleteLabelCommand")
    @RequestMapping(value = "/removeLabel", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> removeLabel(@RequestBody DeleteLabelCommand command) {
        labelHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }

    @ApiOperation(value = "Label Query", notes = "查询标签")
    @ApiImplicitParam(name = "command", value = "查询命令", dataType = "QueryLabelCommand")
    @RequestMapping(value = "/queryData", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> queryData(@RequestBody QueryLabelCommand command) {
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
        List<Label> diaryList = mongoTemplate.find(query, Label.class);
        long count = mongoTemplate.count(query, Label.class);
        result.put("state", SUCCESS);
        result.put("code", SUCCESSCODE);
        result.put("data", diaryList);
        result.put("total", count);
        return result;
    }

}
