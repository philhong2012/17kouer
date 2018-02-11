package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     *
     * @return 返回用户实体
     */
    User selectByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}