package com.example.postbackend.service.component;

import com.example.postbackend.client.api.ContactsApi;
import com.example.postbackend.client.handler.ApiClient;
import com.example.postbackend.client.model.Contact;
import com.example.postbackend.client.model.ContactRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactComponentTest {
    private static final String API_KEY = "2347edfd-c55c-4f59-96ee-600492f904f3";
    private static final String HTTP_LOCALHOST = "http://localhost:";
    private static final String BASE_PATH = "/post/backend/v1";

    public static final String NAME = "Quang Huy";
    public static final String EMAIL = "huy@gmail.com";
    public static final String MESSAGE = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin";

    private ContactsApi api;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        String url = HTTP_LOCALHOST + port + BASE_PATH;
        ApiClient client = new ApiClient();
        client.setBasePath(url);
        api = new ContactsApi(client);
    }

    @Test
    public void ensureContactAdded() {
        Contact contact = api.addContact(API_KEY, mockContactRequest());
    }

    @Test
    public void ensureContactAddThrowExceptionWhenNameFieldNotPass() {
        thrown.expect(HttpClientErrorException.class);
        ContactRequest contactRequest = mockContactRequest();
        contactRequest.setName("");

        api.addContact(API_KEY, contactRequest);
    }

    @Test
    public void ensureContactAddThrowExceptionWhenEmailFieldNotPass() {
        thrown.expect(HttpClientErrorException.class);
        ContactRequest contactRequest = mockContactRequest();
        contactRequest.setEmail("");

        api.addContact(API_KEY, contactRequest);
    }

    private ContactRequest mockContactRequest() {
        ContactRequest contactRequest = new ContactRequest();

        contactRequest.setName(NAME);
        contactRequest.setEmail(EMAIL);
        contactRequest.setMessage(MESSAGE);

        return contactRequest;
    }
}
