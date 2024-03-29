package com.trackival.mdm.user.entity;

import com.trackival.mdm.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("select user.settings from User user where user.id=:id")
    UserSettings findSettingsById(@Param("id") UUID id);

    @Query("select user.address from User user where user.id=:id")
    Address findAddressById(@Param("id") UUID id);
}
