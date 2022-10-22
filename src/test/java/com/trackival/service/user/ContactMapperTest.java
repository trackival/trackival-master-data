package com.trackival.service.user;

import com.trackival.service.contact.ContactMapper;
import com.trackival.service.contact.Contact;
import com.trackival.service.contact.ContactInput;
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
        assertEquals(input.getFacebook(), contact.getFacebook());
        assertEquals(input.getInstagram(), contact.getInstagram());
        assertEquals(input.getTwitter(), contact.getTwitter());
        assertEquals(input.getWebsite(), contact.getWebsite());
        assertEquals(input.getMail(), contact.getMail());
    }
}
