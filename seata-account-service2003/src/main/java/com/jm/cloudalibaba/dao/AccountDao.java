package com.jm.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long id, @Param("money") BigDecimal money);
}
