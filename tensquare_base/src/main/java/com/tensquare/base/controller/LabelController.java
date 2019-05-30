package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    // findAll
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        System.out.println("◆1◆");
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }
    // findById

    /**
     * 占位符{labelId}里面的值，你要想拿到，
     * 要借助注解：@PathVariable
     * String labelId，和{}里面的要保持一致
     * 如果不一致，要写在("labelId")，
     * 如果写在这里了，String xxxx，就可以随意写了。
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        System.out.println("◆2◆");
        // int i = 1/0;
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelId));
    }
    // save
    /**
     * 页面给我传过来的是Json，
     * 我要想接收，我要用对象来接收。
     * Json转对象，用RequestBody
     * 转成Label对象
     *
     * 这样：@RequestBody Label label
     * 就把页面传过来的Json转成Lable对象了。
     * @param label
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        System.out.println("◆3◆");
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    //    update
    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        System.out.println("◆4◆");
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }
    // deleteById
    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        System.out.println("◆5◆");
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }
    // findSearch

    /**
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        System.out.println("◆6◆");
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }
    // pageQuery

    /**
     *
     * @param label
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size){
        System.out.println("◆7◆");
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}