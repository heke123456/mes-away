package com.awise.qrcode.service.impl;

import java.util.List;
import com.away.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.qrcode.mapper.AwQrcodeMapper;
import com.awise.qrcode.domain.AwQrcode;
import com.awise.qrcode.service.IAwQrcodeService;

/**
 * 二维码Service业务层处理
 * 
 * @author awise
 * @date 2023-09-18
 */
@Service
public class AwQrcodeServiceImpl implements IAwQrcodeService 
{
    @Autowired
    private AwQrcodeMapper awQrcodeMapper;

    /**
     * 查询二维码
     * 
     * @param id 二维码主键
     * @return 二维码
     */
    @Override
    public AwQrcode selectAwQrcodeById(Long id)
    {
        return awQrcodeMapper.selectAwQrcodeById(id);
    }

    /**
     * 查询二维码
     *
     * @param processingprocessID 二维码主键
     * @return 二维码
     */
    @Override
    public AwQrcode selectAwQrcodeByProcessingprocessID(Long processingprocessID)
    {
        return awQrcodeMapper.selectAwQrcodeByProcessingprocessID(processingprocessID);
    }

    /**
     * 查询二维码列表
     * 
     * @param awQrcode 二维码
     * @return 二维码
     */
    @Override
    public List<AwQrcode> selectAwQrcodeList(AwQrcode awQrcode)
    {
        return awQrcodeMapper.selectAwQrcodeList(awQrcode);
    }

    /**
     * 新增二维码
     * 
     * @param awQrcode 二维码
     * @return 结果
     */
    @Override
    public int insertAwQrcode(AwQrcode awQrcode)
    {
        awQrcode.setCreateTime(DateUtils.getNowDate());
        return awQrcodeMapper.insertAwQrcode(awQrcode);
    }

    /**
     * 修改二维码
     * 
     * @param awQrcode 二维码
     * @return 结果
     */
    @Override
    public int updateAwQrcode(AwQrcode awQrcode)
    {
        return awQrcodeMapper.updateAwQrcode(awQrcode);
    }

    /**
     * 批量删除二维码
     * 
     * @param ids 需要删除的二维码主键
     * @return 结果
     */
    @Override
    public int deleteAwQrcodeByIds(Long[] ids)
    {
        return awQrcodeMapper.deleteAwQrcodeByIds(ids);
    }

    /**
     * 删除二维码信息
     * 
     * @param id 二维码主键
     * @return 结果
     */
    @Override
    public int deleteAwQrcodeById(Long id)
    {
        return awQrcodeMapper.deleteAwQrcodeById(id);
    }
}
