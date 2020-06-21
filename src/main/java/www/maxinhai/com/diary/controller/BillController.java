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
import www.maxinhai.com.diary.command.add.AddBillCommand;
import www.maxinhai.com.diary.command.change.ModifyBillCommand;
import www.maxinhai.com.diary.command.other.QueryDiaryCommand;
import www.maxinhai.com.diary.command.remove.DeleteBillCommand;
import www.maxinhai.com.diary.domain.Bill;
import www.maxinhai.com.diary.domain.Diary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
@Api(value = "Bill接口API", description = "账单接口API")
public class BillController extends AbstractController {


    @ApiOperation(value = "Bill Create", notes = "创建账单")
    @ApiImplicitParam(name = "command", value = "创建命令", dataType = "AddBillCommand")
    @RequestMapping(value = "/createBill", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> createBill(@RequestBody AddBillCommand command) {
        billHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        result.put("data", null);
        return result;
    }


    @ApiOperation(value = "Bill Change", notes = "修改账单")
    @ApiImplicitParam(name = "command", value = "修改命令", dataType = "ModifyBillCommand")
    @RequestMapping(value = "/changeBill", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> changeBill(@RequestBody ModifyBillCommand command) {
        billHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Bill Remove", notes = "删除账单")
    @ApiImplicitParam(name = "command", value = "删除命令", dataType = "DeleteBillCommand")
    @RequestMapping(value = "/removeBill", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> removeBill(@RequestBody DeleteBillCommand command) {
        billHandler.handler(command);
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("message", SUCCESS);
        return result;
    }


    @ApiOperation(value = "Bill Query", notes = "查询账单")
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
        List<Bill> diaryList = mongoTemplate.find(query, Bill.class);
        long count = mongoTemplate.count(query, Bill.class);
        result.put("state", SUCCESS);
        result.put("code", SUCCESSCODE);
        result.put("data", diaryList);
        result.put("total", count);
        return result;
    }

}
