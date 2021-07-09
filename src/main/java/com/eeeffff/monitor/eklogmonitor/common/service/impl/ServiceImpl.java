package com.eeeffff.monitor.eklogmonitor.common.service.impl;


import com.eeeffff.monitor.eklogmonitor.common.mapper.BaseMapper;
import com.eeeffff.monitor.eklogmonitor.common.service.IService;

/**
 * <p>
 * IService 实现类（ 泛型：M 是 mapper 对象，T 是实体）
 * </p>
 *
 * @author ly
 * @since 2019-02-19
 */
public class ServiceImpl<M extends BaseMapper<T>, T> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> implements IService<T> {

}
