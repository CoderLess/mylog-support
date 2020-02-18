package com.ibn.entity;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.entity
 * @date ：2020/2/12 21:27
 * @description：事项
 * @version: 1.0
 */
@Data
public class ItemBaseDO {
    /**
     * @author: RenBin
     * @description: 事项文本
     * @date: 2020/2/12 21:27
     */
    private String text;
    /**
     * @author: RenBin
     * @description: 子项
     * @date: 2020/2/17 20:51
     */
    private List<ItemBaseDO> subItemList= Lists.newArrayList();
    private Boolean show=false;
}
