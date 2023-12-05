package com.qxbase.audio.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qxbase.audio.common.system.SystemLog;
import com.qxbase.audio.common.system.mapper.SystemLogMapper;
import com.qxbase.audio.common.system.service.ISystemLogService;
import org.springframework.stereotype.Service;

/**
 * @author ALsW
 * @version 1.0.0
 * @since 2023-06-02
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements ISystemLogService {
}
