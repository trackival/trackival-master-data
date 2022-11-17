package com.trackival.mdm.user.resolver;

import com.netflix.graphql.dgs.*;
import com.trackival.mdm.address.Address;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
import com.trackival.mdm.user.entity.UserSettings;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class UserQuery {
    private UserControl control;

    @DgsQuery
    public @NotNull User findUser(@InputArgument UUID id) {
        return this.control.findUser(id);
    }

    @DgsData(parentType = "User")
    public @NotNull UserSettings settings(DgsDataFetchingEnvironment dfe) {
        final User user = dfe.getSource();
        return this.control.findSettings(user.getId());
    }

    @DgsData(parentType = "User")
    public @NotNull Address address(DgsDataFetchingEnvironment dfe) {
        final User user = dfe.getSource();
        return this.control.findAddress(user.getId());
    }
}
