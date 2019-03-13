package com.bootdo.system1.dao;

import com.bootdo.system1.domain.BookDo;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.List;
import java.util.Map;

public interface BookDao {
    int save(BookDo bookDo);

    int update(BookDo bookDo);

    int remove(Long bookId);

    int count(Map<String, Object> map);

    List<BookDo> list(Map<String, Object> map);

    BookDo get(Long bookId);

    int batchRemove(Long[] bookIds);
}
