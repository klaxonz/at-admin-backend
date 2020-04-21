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
@TableName("at_admin_log")
public class AdminLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 管理员操作日志id
     */
    @TableId(value = "admin_log_id", type = IdType.AUTO)
    private Integer adminLogId;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;


}
