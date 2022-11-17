package com.trackival.mdm.user.control;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.user.dto.UserRegistrationInput;
import com.trackival.mdm.user.dto.UserUpdateInput;
import com.trackival.mdm.user.entity.User;
import com.trackival.mdm.user.entity.UserInterestRepository;
import com.trackival.mdm.user.entity.UserRepository;
import com.trackival.mdm.user.entity.UserSettings;
import com.trackival.mdm.user.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserControl {
    private UserMapper mapper;
    private UserRepository repository;
    private UserInterestRepository interestRepository;

    public @NotNull User findUser(@NotNull UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public @NotNull UserSettings findSettings(@NotNull UUID id) {
        return this.repository.findSettingsById(id);
    }

    public @NotNull Address findAddress(@NotNull UUID id) {
        return this.repository.findAddressById(id);
    }

    public @NotNull User registerUser(@NotNull UserRegistrationInput registration) {
        final User user = this.mapper.toEntity(registration);
        return this.repository.save(user);
    }

    public @NotNull User updateUser(@NotNull UUID id, @NotNull UserUpdateInput update) {
        final User user = this.repository.findById(id).orElseThrow();
        final User modified = this.mapper.update(update, user);
        return this.repository.save(modified);
    }

    public @NotNull List<@NotNull String> addInterest(@NotNull UUID id, @NotNull String interest) {
        return this.interestRepository.addInterest(id, interest);
    }

    public @NotNull List<@NotNull String> removeInterest(@NotNull UUID id, @NotNull String interest) {
        return this.interestRepository.removeInterest(id, interest);
    }
}
