package com.example.postbackend.service.it.steps;

import com.example.postbackend.client.api.ContactsApi;
import com.example.postbackend.client.model.Contact;
import com.example.postbackend.client.model.ContactRequest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.web.client.RestClientException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ContactSteps extends CommonStepConfiguration{
    protected ContactsApi contactApi;
    private RestClientException restClientException;
    private ContactRequest contactRequest;
    private Contact contact;

    private final String API_KEY = "2347edfd-c55c-4f59-96ee-600492f904f3";

    @Before
    public void setup() {
        super.setup();
        contactApi = new ContactsApi(baseApiClient);
    }

    @Given("^user request to add contact with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userRequestToAddPostWith(String name, String email, String message) {
        contactRequest = createContactRequest(name, email, message);
    }

    @When("^user do action add contact$")
    public void userDoActionAddPost() {
        try{
            contact = contactApi.addContact(API_KEY, contactRequest);
        } catch(RestClientException e) {
            restClientException = e;
        }
    }

    @Then("^user action create contact successful with \"([^\"]*)\"$")
    public void userActionIsSuccessfulWith(String code) {
        assertThat(contactApi.getApiClient().getStatusCode().value(), is(Integer.valueOf(code)));
    }

    @Then("^user action create contact failed with \"([^\"]*)\"$")
    public void userActionIsFailedWith(String code) {
        assertThat(getExceptionStatusCode(restClientException), is(code));
    }

    private ContactRequest createContactRequest(String name, String email, String message) {
        ContactRequest contactRequest = new ContactRequest();

        contactRequest.setName(name);
        contactRequest.setEmail(email);
        contactRequest.setMessage(message);

        return contactRequest;
    }

}
