package com.emrekirman.glaceon.user.user.mapper;

import com.emrekirman.glaceon.user.common.mapper.IBaseMapper;
import com.emrekirman.glaceon.user.user.entity.User;
import com.emrekirman.glaceon.user.user.model.UserRequest;
import com.emrekirman.glaceon.user.user.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IBaseMapper<UserRequest, UserResponse, User> {
}
