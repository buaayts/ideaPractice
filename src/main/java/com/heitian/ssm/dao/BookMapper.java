package com.heitian.ssm.dao;

import com.heitian.ssm.model.Book;

public interface BookMapper {
    int deleteByPrimaryKey(String bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}