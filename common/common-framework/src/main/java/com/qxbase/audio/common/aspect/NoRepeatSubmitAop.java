package com.qxbase.audio.common.aspect;

import com.qxbase.audio.common.singleton.SubmitBufferSingleton;
import com.qxbase.audio.common.aspect.annotation.RequestLimit;
import com.qxbase.audio.server.data.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author QingXun123
 * @version 1.0.0
 * @since 2023-08-29
 */
@Aspect
@Component
@Slf4j
public class NoRepeatSubmitAop {

//    @Resource
//    public RedisTemplate redisTemplate;

    //@Synchronized 作用是创建一个互斥锁，保证此时没有其它线程对self对象进行修改。这个是objective-c的一个锁定令牌，防止self对象在同一时间内被其它线程访问，起到线程的保护作用。 一般在公用变量的时候使用，如单例模式或者操作类的static变量中使用。
//    @Synchronized
    @Around("execution(* com.qxbase.audio..server.controller..*.*(..)) && @annotation(nrs)")
    public Object arround(ProceedingJoinPoint pjp, RequestLimit nrs) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = pjp.getArgs();  //获取方法参数
        String key = request.getLocalAddr() + " ：" + request.getServletPath();
        Long time = nrs.time();
        Object o = pjp.proceed();
        HashMap<String, LocalDateTime> hashMap = SubmitBufferSingleton.getInstance();
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, LocalDateTime.now());
            return o;
        } else {
            if (Duration.between(hashMap.get(key), LocalDateTime.now()).toMillis() > time) {
                hashMap.put(key, LocalDateTime.now());
                return o;
            } else {
                log.error("操作过于频繁 {}", key);
                return Result.rError("操作过于频繁");
            }
        }

//        if (!redisTemplate.hasKey(key)) {// 如果缓存中没有这个url就执行方法
//            Object o = pjp.proceed();
//            Long time = nrs.time();     //获取RequestLimit注解中参数设置的值
//            System.out.println("限制 "+time+"毫秒内只能访问一次，能正常访问");
//            redisTemplate.opsForValue().set(key, 0, time.intValue(), TimeUnit.MILLISECONDS);
//            return o;
//        } else {    // 如果缓存中有这个url视为重复提交
//            System.out.println("请勿重复提交或者操作过于频繁！");
//            return "请勿重复提交或者操作过于频繁！";
//        }

    }

}
