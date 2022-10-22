package com.trackival.service.user.entity;

import com.trackival.service.common.BaseEntity;
import com.trackival.service.common.StringListAttributeConverter;
import com.trackival.service.contact.Contact;
import com.trackival.service.address.entity.Address;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends BaseEntity {

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @Column(nullable = false, unique = true)
    private String mail;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Nullable
    private String biography = null;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Builder.Default
    @Column(name = "interests", nullable = false)
    @Convert(converter = StringListAttributeConverter.class)
    private List<String> interests = new ArrayList<>();

    @Builder.Default
    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "settings_id", referencedColumnName = "id")
    private UserSettings settings = new UserSettings();
}
