package www.maxinhai.com.diary.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diary.command.add.AddNoteCommand;
import www.maxinhai.com.diary.command.change.ModifyNoteCommand;
import www.maxinhai.com.diary.command.remove.DeleteNoteCommand;
import www.maxinhai.com.diary.domain.Note;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.Validate;
import java.util.Date;
import java.util.UUID;


/**
 * 便签处理器
 */
@Service
public class NoteHandler extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(NoteHandler.class);


    /**
     * 添加便签
     * @param command
     */
    public void handler(AddNoteCommand command) {
        Note note = new Note();
        note.setId(UUID.randomUUID());
        note.setContent(command.getContent());
        note.setCreateTime(new Date());
        note.setCreatorId(null);
        note.setCreator(null);
        noteRepository.save(note);
    }


    /**
     * 修改便签
     * @param command
     */
    public void handler(ModifyNoteCommand command) {
        Note note = getNote(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(note), command.getId() + "数据不存在!");
        note.setContent(command.getContent());
        note.setModifyTime(new Date());
        noteRepository.save(note);
    }


    /**
     * 删除便签
     * @param command
     */
    public void handler(DeleteNoteCommand command) {
        Note note = getNote(command.getId());
        Validate.execAssert(EmptyUtils.isEmpty(note), command.getId() + "数据不存在!");
        noteRepository.delete(note);
    }
}
