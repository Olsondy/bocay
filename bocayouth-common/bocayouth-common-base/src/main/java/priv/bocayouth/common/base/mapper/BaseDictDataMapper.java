package priv.bocayouth.common.base.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import priv.bocayouth.common.base.domain.SysDictData;
import priv.bocayouth.common.base.domain.vo.BaseDictDataVo;
import priv.bocayouth.common.core.feat.mybaits.BaseMapperPlus;

import java.util.List;

/**
 * 字典表 数据层
 *
 * @author Lion Li
 */
public interface BaseDictDataMapper extends BaseMapperPlus<SysDictData, BaseDictDataVo> {

    /**
     * 根据字典类型查询字典数据列表
     *
     * @param dictType 字典类型
     * @return 符合条件的字典数据列表
     */
    default List<BaseDictDataVo> selectDictDataByType(String dictType) {
        return selectVoList(
            new LambdaQueryWrapper<SysDictData>()
                .eq(SysDictData::getDictType, dictType)
                .orderByAsc(SysDictData::getDictSort));
    }
}
