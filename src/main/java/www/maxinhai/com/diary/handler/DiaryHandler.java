package www.maxinhai.com.diary.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diary.command.add.AddDiaryCommand;
import www.maxinhai.com.diary.command.remove.DeleteDiaryCommand;
import www.maxinhai.com.diary.command.change.ModifyDiaryCommand;
import www.maxinhai.com.diary.domain.Diary;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.Validate;

import java.util.Date;
import java.util.UUID;

/**
 * 日记处理器
 */
@Service
public class DiaryHandler extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(DiaryHandler.class);

    /**
     * 添加日记
     * @param command
     */
    public void handler(AddDiaryCommand command) {
        Diary diary = new Diary();
        diary.setId(UUID.randomUUID());
        diary.setName(command.getName());
        diary.setContent(command.getContent());
        diary.setCreateTime(command.getCreateTime());
        diary.setCreator(command.getAuthor());
        diary.setCreatorId(command.getAuthorId());
        diaryRepository.save(diary);
    }


    /**
     * 修改日记
     * @param command
     */
    public void handler(ModifyDiaryCommand command) {
        Diary diary = getDiary(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(diary), command.getId() + "数据不存在!");
        diary.setName(command.getName());
        diary.setContent(command.getContent());
        diary.setLabelList(command.getLabelList());
        diary.setModifyTime(new Date());
        diaryRepository.save(diary);
    }


    /**
     * 删除日记
     * @param command
     */
    public void handler(DeleteDiaryCommand command) {
        Diary diary = getDiary(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(diary), command.getId() + "数据不存在!");
        diaryRepository.delete(diary);
    }
}
