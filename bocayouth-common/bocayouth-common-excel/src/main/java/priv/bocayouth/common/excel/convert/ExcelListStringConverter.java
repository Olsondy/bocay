package priv.bocayouth.common.excel.convert;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.idev.excel.converters.Converter;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;
import priv.bocayouth.common.core.feat.service.DictService;
import priv.bocayouth.common.core.utils.SpringUtils;
import priv.bocayouth.common.core.utils.StringUtils;
import priv.bocayouth.common.excel.annotation.ExcelDictFormat;
import priv.bocayouth.common.excel.utils.ExcelUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.StringJoiner;


/**
 *
 * @author Olsond
 * @description 启动程序
 * @date 2025/9/14
 */
public class ExcelListStringConverter implements Converter<List<String>> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return List.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    // For import (if needed): Convert cell string to List
    @Override
    public List<String> convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String value = cellData.getStringValue();
        return List.of(value.split(","));
    }

    // For export: Convert List to comma-separated string
    @Override
    public WriteCellData<?> convertToExcelData(List<String> dataList, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        if (CollectionUtil.isEmpty(dataList)) {
            return new WriteCellData<>("");
        }
        ExcelDictFormat anno = getAnnotation(contentProperty.getField());
        String type = anno.dictType();
        StringJoiner joiner = new StringJoiner(",");
        dataList.forEach(val -> {
            String label;
            if (StringUtils.isBlank(type)) {
                label = ExcelUtil.convertByExp(val, anno.readConverterExp(), anno.separator());
            } else {
                label = SpringUtils.getBean(DictService.class).getDictLabel(type, val, anno.separator());
            }
            joiner.add(label);
        });
        return new WriteCellData<>(joiner.toString());
    }

    private ExcelDictFormat getAnnotation(Field field) {
        return AnnotationUtil.getAnnotation(field, ExcelDictFormat.class);
    }
}