package com.trackival.mdm.user.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.dto.UserRegistrationInput;
import com.trackival.mdm.user.dto.UserUpdateInput;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class UserMutation {
    private UserControl control;

    @DgsMutation
    public @NotNull User registerUser(@InputArgument UserRegistrationInput registration) {
        return this.control.registerUser(registration);
    }

    @DgsMutation
    public @NotNull User updateUser(@InputArgument UUID id, @InputArgument UserUpdateInput update) {
        return this.control.updateUser(id, update);
    }

    @DgsMutation
    public @NotNull List<@NotNull String> addInterest(@InputArgument UUID id, @InputArgument String interest) {
        return this.control.handleInterest(id, interest, true);
    }

    @DgsMutation
    public @NotNull List<@NotNull String> removeInterest(@InputArgument UUID id, @InputArgument String interest) {
        return this.control.handleInterest(id, interest, true);
    }
}
