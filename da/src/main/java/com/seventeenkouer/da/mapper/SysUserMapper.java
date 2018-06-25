package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}