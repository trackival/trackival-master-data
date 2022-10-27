package com.trackival.service.user.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Component
public class UserInterestRepository {
    @PersistenceUnit
    private EntityManagerFactory factory;

    public @NotNull List<@NotNull String> addInterest(UUID id, String interest) {
        final User result = doTransactional(User.class, id, user -> user.getInterests().add(interest));
        if (result == null) {
            return Collections.emptyList();
        }
        return result.getInterests();
    }

    public @NotNull List<@NotNull String> removeInterest(UUID id, String interest) {
        final User result = doTransactional(User.class, id, user -> user.getInterests().remove(interest));
        if (result == null) {
            return Collections.emptyList();
        }
        return result.getInterests();
    }

    private <T> @Nullable T doTransactional(Class<T> clazz, Object key, Consumer<T> consumer) {
        final EntityManager manager = this.factory.createEntityManager();
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
