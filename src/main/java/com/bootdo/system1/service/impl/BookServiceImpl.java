package com.bootdo.system1.service.impl;

import com.bootdo.system1.dao.BookDao;
import com.bootdo.system1.domain.BookDo;
import com.bootdo.system1.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookMapper;
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public int save(BookDo bookDo) {
        bookDo.setGmtGrounding(new Date());
        return bookMapper.save(bookDo);
    }

    @Override
    public int update(BookDo bookDo) {
        bookDo.setGmtUpdate(new Date());
        return bookMapper.update(bookDo);
    }

    @Override
    public int remove(Long bookId) {
        return bookMapper.remove(bookId);
    }

    @Override
    public int count(Map<String, Object> map) {
        return bookMapper.count(map);
    }

    @Override
    public List<BookDo> list(Map<String, Object> map) {
        return bookMapper.list(map);
    }

    @Override
    public BookDo get(Long bookId) {
        return bookMapper.get(bookId);
    }

    @Override
    public int batchRemove(Long[] bookIds) {
        return bookMapper.batchRemove(bookIds);
    }
}
