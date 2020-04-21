package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("at_announce")
public class Announce implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 公告id
     */
    @TableId(value = "announce_id", type = IdType.AUTO)
    private Integer announceId;

    /**
     * 公告标题
     */
    private String announceTitle;

    /**
     * 公告类型
     */
    private Integer announceType;

    /**
     * 公告发布者
     */
    private Integer userId;

    /**
     * 公告发布时间
     */
    private LocalDateTime publishTime;


}
