package com.ibn.vo;

import com.ibn.base.entity.BaseVO;
import com.ibn.entity.ItemBaseDO;
import lombok.Data;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.vo
 * @date ：2020/2/12 21:11
 * @description：事务相关
 * @version: 1.0
 */
@Data
public class ItemVO extends BaseVO {
    /**
     * @author: RenBin
     * @description: 待办事项
     * @date: 2020/2/12 21:16
     */
    private List<ItemBaseDO> waitItemList;
    /**
     * @author: RenBin
     * @description: 完成事项
     * @date: 2020/2/12 21:16
     */
    private List<ItemBaseDO> complateItemList;
    /**
     * @author: RenBin
     * @description: 抛弃事项
     * @date: 2020/2/12 21:16
     */
    private List<ItemBaseDO> abandonItemList;
}
