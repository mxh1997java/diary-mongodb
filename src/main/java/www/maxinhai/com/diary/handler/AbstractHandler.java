package www.maxinhai.com.diary.handler;

import org.springframework.beans.factory.annotation.Autowired;
import www.maxinhai.com.diary.domain.*;
import www.maxinhai.com.diary.repository.*;
import www.maxinhai.com.diary.util.EmptyUtils;
import www.maxinhai.com.diary.util.Validate;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractHandler {

    @Autowired
    protected DiaryRepository diaryRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected LabelRepository labelRepository;
    @Autowired
    protected NoteRepository noteRepository;
    @Autowired
    protected BillRepository billRepository;
    @Autowired
    protected LoginInfoRepository loginInfoRepository;

    protected static final String KEY = "maxinhai";


    /**
     * 根据id获取Diary
     * @param id
     * @return
     */
    protected Diary getDiary(UUID id) {
        Validate.execAssert(EmptyUtils.isEmpty(id), "id不为空!");
        Optional<Diary> optional = diaryRepository.findById(id);
        return optional.get();
    }


    /**
     * 根据id获取Note
     * @param id
     * @return
     */
    protected Note getNote(UUID id) {
        Validate.execAssert(EmptyUtils.isEmpty(id), "id不为空!");
        Optional<Note> optional = noteRepository.findById(id);
        return optional.get();
    }


    /**
     * 根据id获取Bill
     * @param id
     * @return
     */
    protected Bill getBill(UUID id) {
        Validate.execAssert(EmptyUtils.isEmpty(id), "id不为空!");
        Optional<Bill> optional = billRepository.findById(id);
        return optional.get();
    }


    /**
     * 根据id获取User
     * @param id
     * @return
     */
    protected User getUser(UUID id) {
        Validate.execAssert(EmptyUtils.isEmpty(id), "id不为空!");
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    }


    /**
     * 根据id获取Label
     * @param id
     * @return
     */
    protected Label getLabel(UUID id) {
        Validate.execAssert(EmptyUtils.isEmpty(id), "id不为空!");
        Optional<Label> optional = labelRepository.findById(id);
        return optional.get();
    }

}
