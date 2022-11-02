package com.trackival.mdm.user.resolver;

import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.dto.UserRegistrationInput;
import com.trackival.mdm.user.dto.UserUpdateInput;
import com.trackival.mdm.user.entity.User;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserMutation implements GraphQLMutationResolver {
    private UserControl control;

    public @NotNull User registerUser(@NotNull UserRegistrationInput registration) {
        return this.control.registerUser(registration);
    }

    public @NotNull User updateUser(@NotNull UUID id, @NotNull UserUpdateInput update) {
        return this.control.updateUser(id, update);
    }

    public @NotNull List<@NotNull String> addInterest(@NotNull UUID id, @NotNull String interest) {
        return this.control.addInterest(id, interest);
    }

    public @NotNull List<@NotNull String> removeInterest(@NotNull UUID id, @NotNull String interest) {
        return this.control.removeInterest(id, interest);
    }
}
