package com.soft863.framework.push.service.impl;

import com.soft863.framework.push.dao.PushDao;
import com.soft863.framework.push.domain.PushDO;
import com.soft863.framework.push.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PushServiceImpl implements PushService {
    @Autowired
    private PushDao pushDao;

    @Override
    public PushDO get(Integer pushId) {
        return pushDao.get(pushId);
    }

    @Override
    public List<PushDO> list(Map<String, Object> map) {
        return pushDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return pushDao.count(map);
    }

    @Override
    public int save(PushDO push) {
        if (push.getStatus() == 0) {
            push.setStatus(0L);
        }
        return pushDao.save(push);
    }

    @Override
    public int update(PushDO push) {
        return pushDao.update(push);
    }

    @Override
    public int remove(Integer pushId) {
        return pushDao.remove(pushId);
    }

    @Override
    public int batchRemove(Integer[] pushIds) {
        return pushDao.batchRemove(pushIds);
    }

}
