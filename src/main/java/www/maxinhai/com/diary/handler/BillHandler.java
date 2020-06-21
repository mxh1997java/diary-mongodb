package www.maxinhai.com.diary.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diary.command.add.AddBillCommand;
import www.maxinhai.com.diary.command.change.ModifyBillCommand;
import www.maxinhai.com.diary.command.remove.DeleteBillCommand;
import www.maxinhai.com.diary.domain.Bill;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.Validate;

import java.util.Date;
import java.util.UUID;


/**
 * 账单处理器
 */
@Service
public class BillHandler extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(BillHandler.class);

    /**
     * 添加账单
     * @param command
     */
    public void handler(AddBillCommand command) {
        Bill bill = new Bill();
        bill.setId(UUID.randomUUID());
        bill.setLabel(command.getLabel());
        bill.setLabelId(command.getLabelId());
        bill.setAmount(command.getAmount());
        billRepository.save(bill);
    }


    /**
     * 修改账单
     * @param command
     */
    public void handler(ModifyBillCommand command) {
        Bill bill = getBill(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(bill), command.getId() + "数据不存在!");
        bill.setAmount(command.getAmount());
        bill.setLabelId(command.getLabelId());
        bill.setLabel(command.getLabel());
        bill.setModifyTime(new Date());
        billRepository.save(bill);
    }


    /**
     * 删除帐单
     * @param command
     */
    public void handler(DeleteBillCommand command) {
        Bill bill = getBill(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(bill), command.getId() + "数据不存在!");
        billRepository.delete(bill);
    }
}
