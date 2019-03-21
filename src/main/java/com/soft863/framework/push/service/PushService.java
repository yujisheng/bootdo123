package com.soft863.framework.push.service;

import com.soft863.framework.push.domain.PushDO;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 15:21:21
 */
public interface PushService {

    PushDO get(Integer pushId);

    List<PushDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PushDO push);

    int update(PushDO push);

    int remove(Integer pushId);

    int batchRemove(Integer[] pushIds);
}
