package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("at_location")
@ApiModel(value="Location对象", description="")
public class Location implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "地点id")
    @TableId(value = "location_id", type = IdType.AUTO)
    private Integer locationId;

    @ApiModelProperty(value = "地点名称")
    private String locationName;


}
