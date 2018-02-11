package com.seventeenkouer.facade;

import com.seventeenkouer.common.Exception.SeventeenkouException;
import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.mapper.UserMapper;
import com.seventeenkouer.da.model.User;
import com.seventeenkouer.facade.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户接口
 *
 * @author hongxubing
 * @create 2018-02-11 15:40
 **/
@Service("UserFaceImpl")
public class UserFaceImpl implements UserFace {
    @Autowired
    UserMapper userMapper;
    @Override
    public void login(UserDto userDto) {
        //todo:参数空判断，引入什么来做这个事情呢？
        User dbUser = userMapper.selectByLoginNameAndPassword(userDto.getLoginName(),userDto.getPassword());
        if(dbUser == null) {
            throw new SeventeenkouException(ResultCode.LOGIN_FAILED);
        }
    }
}
