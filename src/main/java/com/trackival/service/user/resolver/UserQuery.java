package com.trackival.service.user.resolver;

import com.trackival.service.user.control.UserControl;
import com.trackival.service.user.entity.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserQuery implements GraphQLQueryResolver {
    private UserControl control;

    public User findUser(@NotNull UUID id) {
        return this.control.findUser(id);
    }
}
