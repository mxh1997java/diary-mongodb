package www.maxinhai.com.diary.domain;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 基础类
 */
@Data
public class BaseEntity implements Serializable {

    protected static final long serialVersionUID = -3258839839160856613L;

    /**
     * 名称
     */
    protected String name;

    /**
     * 描述
     */
    protected String description;

    /**
     * 创造时间
     */
    protected Date createTime;

    /**
     * 修改时间
     */
    protected Date modifyTime;

    /**
     * 创建者
     */
    protected String creator;


    protected UUID creatorId;

    /**
     * 修改者
     */
    protected String editor;

    protected String editorId;

}
