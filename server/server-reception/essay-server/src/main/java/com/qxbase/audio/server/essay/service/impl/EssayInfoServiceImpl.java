package com.qxbase.audio.server.essay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qxbase.audio.data.entity.EssayInfo;
import com.qxbase.audio.server.essay.mapper.EssayInfoMapper;
import com.qxbase.audio.server.essay.service.IEssayInfoService;
import org.springframework.stereotype.Service;

@Service
public class EssayInfoServiceImpl extends ServiceImpl<EssayInfoMapper, EssayInfo> implements IEssayInfoService {

}
