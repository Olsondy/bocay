package priv.bocayouth.common.base.domain.vo;

import lombok.Data;

/**
 * 上传对象信息
 *
 * @author Michelle.Chung
 */
@Data
public class BaseOssUploadVo {

    /**
     * URL地址
     */
    private String url;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 对象存储主键
     */
    private String ossId;

}
