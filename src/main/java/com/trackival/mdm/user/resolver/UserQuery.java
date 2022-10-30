package com.trackival.mdm.user.resolver;

import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
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
