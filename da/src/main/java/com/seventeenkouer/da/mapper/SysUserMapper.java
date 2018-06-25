package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 验证用户名密码
     * @param account 用户账号
     * @param password 用户密码
     * @return 0:用户名密码错误 1：用户名或密码正确
     */
    Integer validateUser(@Param("account") String account, @Param("password") String password);
}