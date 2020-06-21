package www.maxinhai.com.diary.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diary.command.add.AddLabelCommand;
import www.maxinhai.com.diary.command.change.ModifyLabelCommand;
import www.maxinhai.com.diary.command.remove.DeleteLabelCommand;
import www.maxinhai.com.diary.domain.Label;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.Validate;

import java.util.Date;
import java.util.UUID;


/**
 * 标签处理器
 */
@Service
public class LabelHandler extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(LabelHandler.class);


    /**
     * 添加标签
     * @param command
     */
    public void handler(AddLabelCommand command) {
        Label label = new Label();
        label.setId(UUID.randomUUID());
        label.setName(command.getName());
        label.setDescription(command.getDescription());
        label.setState(1);
        labelRepository.save(label);
    }


    /**
     * 修改标签
     * @param command
     */
    public void handler(ModifyLabelCommand command) {
        Label label = getLabel(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(label), command.getId() + "数据不存在!");
        label.setModifyTime(new Date());
        labelRepository.save(label);
    }


    /**
     * 删除标签
     * @param command
     */
    public void handler(DeleteLabelCommand command) {
        Label label = getLabel(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(label), command.getId() + "数据不存在!");
        labelRepository.delete(label);
    }
}
