package net.damoniy.javaspringboot.utils.mapper;

import net.damoniy.javaspringboot.domain.entity.User;
import net.damoniy.javaspringboot.rest.dto.UserView;

public class UserViewMapper implements RawMapper<User, UserView> {
    @Override
    public UserView map(User user) {
        return new UserView(user.getName(), user.getEmail(), user.getPhone());
    }
}
