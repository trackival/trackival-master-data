package com.trackival.mdm.common;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.function.Consumer;

@Component
@AllArgsConstructor
public class TransactionalEntityModifier {
    @PersistenceUnit
    private EntityManagerFactory factory;

    public  <T> @Nullable T doTransactional(Class<T> clazz, Object key, Consumer<T> consumer) {
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
