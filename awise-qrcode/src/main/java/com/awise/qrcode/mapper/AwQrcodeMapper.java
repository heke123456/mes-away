package com.awise.qrcode.mapper;

import java.util.List;
import com.awise.qrcode.domain.AwQrcode;

/**
 * 二维码Mapper接口
 * 
 * @author awise
 * @date 2023-09-18
 */
public interface AwQrcodeMapper 
{
    /**
     * 查询二维码
     * 
     * @param id 二维码主键
     * @return 二维码
     */
    public AwQrcode selectAwQrcodeById(Long id);

    /**
     * 查询二维码
     *
     * @param processingprocessID 二维码主键
     * @return 二维码
     */
    public AwQrcode selectAwQrcodeByProcessingprocessID(Long processingprocessID);

    /**
     * 查询二维码列表
     * 
     * @param awQrcode 二维码
     * @return 二维码集合
     */
    public List<AwQrcode> selectAwQrcodeList(AwQrcode awQrcode);

    /**
     * 新增二维码
     * 
     * @param awQrcode 二维码
     * @return 结果
     */
    public int insertAwQrcode(AwQrcode awQrcode);

    /**
     * 修改二维码
     * 
     * @param awQrcode 二维码
     * @return 结果
     */
    public int updateAwQrcode(AwQrcode awQrcode);

    /**
     * 删除二维码
     * 
     * @param id 二维码主键
     * @return 结果
     */
    public int deleteAwQrcodeById(Long id);

    /**
     * 批量删除二维码
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwQrcodeByIds(Long[] ids);
}
