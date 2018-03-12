package com.akos.library.client;

import com.akos.library.client.api.PersonService;
import com.akos.library.common.entity.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class Library implements EntryPoint {


    private final VerticalPanel mainPanel = new VerticalPanel();
    private PersonService personService = GWT.create(PersonService.class);

    public void onModuleLoad() {

        RootPanel.get("mainContainer").add(mainPanel);

        Defaults.setServiceRoot(GWT.getHostPageBaseURL());


        personService.getAll(new MethodCallback<List<Person>>() {

            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert(throwable.getMessage());
            }

            @Override
            public void onSuccess(Method method, List<Person> personList) {
                for (Person person : personList) {
                    mainPanel.add(new Label(person.getFirstName() + " " + person.getLastName()));
                }
            }
        });

        personService.get(1L, new MethodCallback<Person>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert(throwable.getMessage());
            }

            @Override
            public void onSuccess(Method method, Person person) {
                mainPanel.add(new Label("********************************************************************"));
                mainPanel.add(new Label(person.getFirstName() + " " + person.getLastName()));
                mainPanel.add(new Label("********************************************************************"));
            }
        });
 }
}
