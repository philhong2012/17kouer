package com.seventeenkouer.facade;

import com.seventeenkouer.facade.dto.UserDto;

/**
 * 用户模块接口
 *
 * @author hongxubing
 * @create 2018-02-11 15:34
 **/
public interface UserFace {
    /**
     * 验证用户登录权限，不通过抛出异常
     * @param userDto
     */
    void login(UserDto userDto);

}
