package com.example.demo.mapper;

import com.example.demo.model.Question;
import jdk.Exported;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    //增删改查


    //增加question
    @Insert("insert into question (id,item,value1,value2) values (#{id},#{item},#{value1},#{value2})")
    void addqution(Integer id,String item,Integer value1,Integer value2);


    //删除问题
    @Delete("delete from question where id=#{id}")
    void deleteqiestion(Integer id);

    //修改问题
    @Update("update question set item=#{item},value1=#{value1},value2=#{value2} where id=#{id}")
    void updatequestion(Integer id,String item,Integer value1,Integer value2);


    //得到一个问题，即查询问题
    @Select("select * from question where id=#{id}")
    Question getquestion(Integer id);

    //查询所有问题
    @Select("select * from question")
    List<Question> getallquestion();
}
