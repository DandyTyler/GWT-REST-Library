package com.akos.library.client.ui.mainpanel;

import com.akos.library.common.entity.Person;
import com.github.nmorel.gwtjackson.client.ObjectReader;
import com.github.nmorel.gwtjackson.client.ObjectWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class MainPanel extends Composite {

    interface Binder extends UiBinder<Widget, MainPanel> {
    }
    private static final Binder binder = GWT.create(Binder.class);

    private static final String JSON_URL = GWT.getModuleBaseURL() + "person";

    public static interface PersonWriter extends ObjectWriter<List<Person>> {
    }

    public static interface PersonReader extends ObjectReader<List<Person>> {

    }

    private static final PersonWriter PERSON_WRITER = GWT.create(PersonWriter.class);
    private static final PersonReader PERSON_READER = GWT.create(PersonReader.class);

    public MainPanel() {
        initWidget(binder.createAndBindUi(this));
        jsonRequestUrlLabel.setText("Trying get json: " + JSON_URL);
        serverResponse.setText("No Response");
        errorMsgLabel.setText("No Error");
        action();
    }

    @UiField
    Label jsonRequestUrlLabel;
    @UiField
    Label serverResponse;
    @UiField
    Label errorMsgLabel;

    void action(){
        try {
            RequestBuilder builder = new RequestBuilder( RequestBuilder.GET, JSON_URL);
            builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()){

                        List<Person> receivedPersons = PERSON_READER.read(response.getText());
                        serverResponse.setText("Received from JSON controller: "+ receivedPersons);
                        errorMsgLabel.setText("OK!!");

                    }
                    else {
                        errorMsgLabel.setText("Error!");
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    errorMsgLabel.setText("Sending request failed!");
                }
            });

        } catch (RequestException e) {
            errorMsgLabel.setText("Request exception!");
        }
    }
}