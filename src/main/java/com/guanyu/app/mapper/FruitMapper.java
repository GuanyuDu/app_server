package com.guanyu.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.base.Fruit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Guanyu
 */
public interface FruitMapper extends BaseMapper<Fruit> {

    /**
     * get fruit data by id
     * @param id Integer
     * @return fruit object
     */
    @Select("select * from test_fruit where id = #{id}")
    Fruit getFruitById(Integer id);

    /**
     * get all fruit
     * @return fruit of list
     */
    @Select("select * from test_fruit")
    List<Fruit> getAllFruit();

    /**
     * insert fruit
     * @param fruit object
     * @return boolean
     */
    @Insert("insert into test_fruit value(#{id}, #{name}, #{price})")
    boolean insertFruit(Fruit fruit);
}
