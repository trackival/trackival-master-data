package com.trackival.mdm.contact.control;

import com.trackival.mdm.contact.entity.ContactRepository;
import com.trackival.mdm.contact.entity.Contact;
import com.trackival.mdm.event.control.EventControl;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactControl {
    private UserControl userControl;
    private EventControl eventControl;
    private ContactRepository repository;

    public List<Contact> findUserContact(UUID userId) {
        return this.repository.findUserContact(userId);
    }

    public List<Contact> findEventContact(UUID eventId) {
        return this.repository.findEventContact(eventId);
    }

    public void deleteUserContact(UUID userId, String key) {
        this.repository.deleteUserContact(userId, key);
    }

    public void deleteEventContact(UUID eventId, String key) {
        this.repository.deleteEventContact(eventId, key);
    }

    public List<Contact> saveUserContact(UUID userId, String key, String value) {
        final User user = this.userControl.findUser(userId);
        final Contact contact = Contact.builder().user(user).contactKey(key).contactValue(value).build();
        this.repository.save(contact);
        return this.findUserContact(userId);
    }

    public List<Contact> saveEventContact(UUID eventId, String key, String value) {
        final Event event = this.eventControl.findEvent(eventId);
        final Contact contact = Contact.builder().event(event).contactKey(key).contactValue(value).build();
        this.repository.save(contact);
        return this.findEventContact(eventId);
    }
}
