package com.trackival.service.user.entity;

import com.trackival.service.address.entity.Address;
import com.trackival.service.contact.Contact;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Component
public class ExtendedUserRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public User updateUser(UUID id, String firstName, String lastName, String mail, String password, LocalDate dateOfBirth, String biography, Address address, Contact contact, Gender gender) {
        return this.doTransactional(User.class, id, user -> {
            Optional.ofNullable(firstName).ifPresent(user::setFirstName);
            Optional.ofNullable(lastName).ifPresent(user::setLastName);
            Optional.ofNullable(mail).ifPresent(user::setMail);
            Optional.ofNullable(password).ifPresent(user::setPassword);
            Optional.ofNullable(dateOfBirth).ifPresent(user::setDateOfBirth);
            Optional.ofNullable(biography).ifPresent(user::setBiography);
            Optional.ofNullable(address).map(a -> user.getAddress().merge(a)).ifPresent(user::setAddress);
            Optional.ofNullable(contact).map(c -> user.getContact().merge(c)).ifPresent(user::setContact);
            Optional.ofNullable(gender).ifPresent(user::setGender);
        });
    }

    public List<String> addInterest(UUID id, String interest) {
        final User result = doTransactional(User.class, id, user -> user.getInterests().add(interest));
        if (result == null) {
            return Collections.emptyList();
        }
        return result.getInterests();
    }

    public List<String> removeInterest(UUID id, String interest) {
        final User result = doTransactional(User.class, id, user -> user.getInterests().remove(interest));
        if (result == null) {
            return Collections.emptyList();
        }
        return result.getInterests();
    }

    private <T> @Nullable T doTransactional(Class<T> clazz, Object key, Consumer<T> consumer) {
        final EntityManager manager = this.entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            final T value = manager.find(clazz, key);
            if (value == null) {
                return null;
            }
            consumer.accept(value);
            manager.merge(value);
            transaction.commit();
            return value;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            transaction.rollback();
            return null;
        }
    }
}
