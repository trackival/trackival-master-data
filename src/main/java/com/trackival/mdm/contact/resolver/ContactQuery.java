package com.trackival.mdm.contact.resolver;

import com.netflix.graphql.dgs.*;
import com.trackival.mdm.contact.control.ContactControl;
import com.trackival.mdm.contact.dto.AddContactInput;
import com.trackival.mdm.contact.dto.RemoveContactInput;
import com.trackival.mdm.contact.entity.Contact;
import com.trackival.mdm.contact.exception.CouldNotAddContactException;
import com.trackival.mdm.contact.exception.CouldNotRemoveContactException;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;

import java.util.List;

@DgsComponent
@AllArgsConstructor
public class ContactQuery {
    private ContactControl control;

    @DgsData(parentType = "User", field = "contact")
    public List<Contact> findUserContact(DgsDataFetchingEnvironment environment) {
        final User user = environment.getSource();
        return this.control.findUserContact(user.getId());
    }

    @DgsData(parentType = "Event", field = "contact")
    public List<Contact> findEventContact(DgsDataFetchingEnvironment environment) {
        final Event event = environment.getSource();
        return this.control.findEventContact(event.getId());
    }

    @DgsMutation
    public List<Contact> addContact(@InputArgument AddContactInput data) {
        if (data.isUser()) {
            return this.control.saveUserContact(data.getUserId(), data.getKey(), data.getValue());
        }
        if (data.isEvent()) {
            return this.control.saveEventContact(data.getEventId(), data.getKey(), data.getValue());
        }
        throw new CouldNotAddContactException(data);
    }

    @DgsMutation
    public boolean removeContact(@InputArgument RemoveContactInput data) {
        if (data.isUser()) {
            this.control.deleteUserContact(data.getUserId(), data.getKey());
            return true;
        }
        if (data.isEvent()) {
            this.control.deleteEventContact(data.getEventId(), data.getKey());
            return true;
        }
        throw new CouldNotRemoveContactException(data);
    }
}
