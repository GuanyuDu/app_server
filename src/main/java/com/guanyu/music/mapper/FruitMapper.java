package com.guanyu.music.mapper;

import com.guanyu.music.model.base.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Guanyu
 */
@Mapper
public interface FruitMapper {

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
}
