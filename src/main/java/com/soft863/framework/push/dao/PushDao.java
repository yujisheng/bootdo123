package com.soft863.framework.push.dao;

import com.soft863.framework.push.domain.PushDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 15:21:21
 */
@Mapper
public interface PushDao {

    PushDO get(Integer pushId);

    List<PushDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PushDO push);

    int update(PushDO push);

    int remove(Integer push_id);

    int batchRemove(Integer[] pushIds);
}
