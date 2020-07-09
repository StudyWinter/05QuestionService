package com.example.demo.controller;

import com.example.demo.mapper.QuestionMapper;
import com.example.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class restQutionController {
    @Autowired
    private QuestionMapper questionMapper;

    //增加问题
    @RequestMapping("rest/addquestion")
    public String addquestion(Integer id,String item,Integer value1,Integer value2)
    {
        //先查询
        Question question = questionMapper.getquestion(id);
        if(question!=null)     //有该问题，不可用添加
        {
            return "fault";
        }
        else
        {
            questionMapper.addqution(id, item, value1, value2);
            return "add";
        }
    }


    //删除问题
    @RequestMapping("/rest/deletequestion")
    public String deletequestion(Integer id)
    {
        //先查询
        Question question = questionMapper.getquestion(id);

        if(question!=null)    //有该用户，可删除
        {
            questionMapper.deleteqiestion(id);
            return "delete";
        }
        else
        {
            return "fault";
        }
    }


    //修改问题
    @RequestMapping("/rest/updatequestion")
    public String updatequestion(Integer id,String item,Integer value1,Integer value2)
    {
        //先查询
        Question question = questionMapper.getquestion(id);
        if(question!=null)   //有该问题，可以修改
        {
            questionMapper.updatequestion(id, item, value1, value2);
            return "update";
        }
        else
        {
            return "fault";
        }
    }

    //得到一个问题，查询
    @RequestMapping("/rest/getquestion")
    public Question getquestion(Integer id)
    {
        Question question = questionMapper.getquestion(id);
        return question;
    }

    //得到所有问题，查询所有问题
    @RequestMapping("/rest/getallquestion")
    public List<Question> getallquestion()
    {
        List<Question> list = questionMapper.getallquestion();
        return list;
    }

}
