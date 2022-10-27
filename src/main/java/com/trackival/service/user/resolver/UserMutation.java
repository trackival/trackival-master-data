package com.trackival.service.user.resolver;

import com.trackival.service.user.control.UserControl;
import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.dto.UserUpdateInput;
import com.trackival.service.user.entity.User;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserMutation implements GraphQLMutationResolver {
    private UserControl control;

    public User registerUser(@NotNull UserRegistrationInput registration) {
        return this.control.registerUser(registration);
    }

    public User updateUser(@NotNull UUID id, @NotNull UserUpdateInput update) {
        return this.control.updateUser(id, update);
    }

    public @NotNull List<@NotNull String> addInterest(@NotNull UUID id, @NotNull String interest) {
        return this.control.addInterest(id, interest);
    }

    public @NotNull List<@NotNull String> removeInterest(@NotNull UUID id, @NotNull String interest) {
        return this.control.removeInterest(id, interest);
    }
}
