package com.jstudio.bookstore.data;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

//public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
//    //FIXME 特别注意，该接口不能被扫描到，否则会出错
//}

public interface IMapper<T> {

    int insert(T item);

    int delete(T item);

    int update(T item);

    List<T> getAll();

    T getById();

}
