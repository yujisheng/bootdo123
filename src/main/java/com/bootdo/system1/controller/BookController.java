package com.bootdo.system1.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system1.domain.BookDo;
import com.bootdo.system1.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys1/book")
public class BookController {
    private static final String prefix = "system1/book";

    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("")
    public String book() {
        System.out.println("======================================================");
        return prefix + "/book";
    }


    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 获取查询的相关参数
        Query query = new Query(params);
        List<BookDo> sys1BookList = bookService.list(query);
        int total = bookService.count(query);
        PageUtils pageUtils = new PageUtils(sys1BookList, total);
        return pageUtils;
    }

    @Log("跳转添加页面")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @Log("添加页面表单提交")
    @PostMapping("/save")
    @ResponseBody
    R save(BookDo bookDo) {
        if (bookService.save(bookDo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log("跳转编辑页面")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        BookDo bookDo = bookService.get(id);
        model.addAttribute("book", bookDo);
        return prefix + "/edit";
    }


    @Log("编辑修改表单提交")
    @PostMapping("/update")
    @ResponseBody
    R update(BookDo bookDo) {
        if (bookService.update(bookDo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log("删除图书")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (bookService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log("批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] bookIds) {
        if (bookService.batchRemove(bookIds) > 0) {
            return R.ok();
        }
        return R.error();
    }

}
