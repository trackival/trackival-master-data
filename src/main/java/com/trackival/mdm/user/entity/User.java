package com.trackival.mdm.user.entity;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.common.BaseEntity;
import com.trackival.mdm.common.converter.StringListAttributeConverter;
import com.trackival.mdm.contact.entity.Contact;
import com.trackival.mdm.user.like.entity.Like;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

@Getter
@Setter
@Builder
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends BaseEntity {
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @ToString.Include
    @Column(nullable = false, unique = true)
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private String mail;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @ToString.Include
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Nullable
    @Builder.Default
    private String biography = null;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Builder.Default
    @Column(name = "interests", nullable = false)
    @Convert(converter = StringListAttributeConverter.class)
    private List<String> interests = new ArrayList<>();

    @NotNull
    @Builder.Default
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "settings_id", referencedColumnName = "id")
    private UserSettings settings = new UserSettings();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likedEvents = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contact = new ArrayList<>();
}
