package com.trackival.mdm.mapper;

import com.trackival.mdm.contact.ContactMapper;
import com.trackival.mdm.contact.Contact;
import com.trackival.mdm.contact.ContactInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class ContactMapperTest {
    @Autowired
    private ContactMapper mapper;

    @Test
    void testMapper() {
        final ContactInput input = ContactInput.builder()
                .phone("+49 151 59199380")
                .facebook("goekhantopcu")
                .instagram("goekhantopcu")
                .twitter("@goekhantopcu")
                .website("https://gtopcu.de")
                .mail("goekhan.topcu@telekom.de")
                .build();
        final Contact contact = this.mapper.toEntity(input);

        assertEquals(input.getPhone(), contact.getPhone());
        assertEquals(input.getMail(), contact.getMail());
        assertEquals(input.getTwitter(), contact.getTwitter());
        assertEquals(input.getInstagram(), contact.getInstagram());
        assertEquals(input.getFacebook(), contact.getFacebook());
        assertEquals(input.getWebsite(), contact.getWebsite());
    }
}
