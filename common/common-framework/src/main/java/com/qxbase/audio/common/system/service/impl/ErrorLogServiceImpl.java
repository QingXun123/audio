package com.qxbase.audio.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qxbase.audio.common.system.ErrorLog;
import com.qxbase.audio.common.system.mapper.ErrorLogMapper;
import com.qxbase.audio.common.system.service.IErrorLogService;
import org.springframework.stereotype.Service;

/**
 * @author ALsW
 * @version 1.0.0
 * @since 2023-06-01
 */
@Service
public class ErrorLogServiceImpl extends ServiceImpl<ErrorLogMapper, ErrorLog> implements IErrorLogService {
}
