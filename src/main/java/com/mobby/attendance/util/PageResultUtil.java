package com.mobby.attendance.util;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hulu
 * @ClassName PageResultUtil.java
 * @Description
 * @createTime 2020年04月15日 13:25:00
 */
public class PageResultUtil {

    public static Map<String, Object> result(IPage page) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page.getCurrent());
        map.put("pageSize", page.getSize());
        map.put("total", page.getTotal());
        map.put("list", page.getRecords());
        return map;
    }


}
