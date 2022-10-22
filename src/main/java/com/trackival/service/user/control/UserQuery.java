package com.trackival.service.user.control;

import com.trackival.service.user.entity.User;
import com.trackival.service.user.entity.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {
    private final UserRepository repository;

    public User findUser(UUID id) {
        return this.repository.findById(id).orElse(null);
    }
}
