//package com.akos.library.client;
//
//import com.akos.library.common.entity.Person;
//import com.github.nmorel.gwtjackson.client.ObjectReader;
//import com.github.nmorel.gwtjackson.client.ObjectWriter;
//import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.http.client.*;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.VerticalPanel;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Entry point classes define <code>onModuleLoad()</code>.
// */
//public class Library implements EntryPoint {
//
//    private static final String JSON_URL = GWT.getModuleBaseURL() + "person";
//
//    private Label jsonRequestUrlLabel = new Label();
//    private Label errorMsgLabel = new Label();
//    private Label serverResponse = new Label();
//
//    private VerticalPanel mainPanel = new VerticalPanel();
//
//    public static interface PersonWriter extends ObjectWriter<List<Person>> {
//    }
//
//    public static interface PersonReader extends ObjectReader<List<Person>> {
//
//    }
//
//    private static final PersonWriter PERSON_WRITER = GWT.create(PersonWriter.class);
//    private static final PersonReader PERSON_READER = GWT.create(PersonReader.class);
//
//    /**
//     * This is the entry point method.
//     */
//    @Override
//    public void onModuleLoad() {
//
//        jsonRequestUrlLabel.setText("Trying get json: " + JSON_URL);
//        serverResponse.setText("No Response");
//        errorMsgLabel.setText("No Error");
//
//        mainPanel.add(jsonRequestUrlLabel);
//        mainPanel.add(serverResponse);
//        mainPanel.add(errorMsgLabel);
//
//        RootPanel.get("mainContainer").add(mainPanel);
//
//        try {
//            RequestBuilder builder = new RequestBuilder( RequestBuilder.GET, JSON_URL);
//            builder.sendRequest(null, new RequestCallback() {
//                @Override
//                public void onResponseReceived(Request request, Response response) {
//                    if (200 == response.getStatusCode()){
//
//                        List<Person> receivedPersons = PERSON_READER.read(response.getText());
//                        serverResponse.setText("Received from JSON controller: "+ receivedPersons);
//                        errorMsgLabel.setText("OK!!");
//
//                    }
//                    else {
//                        errorMsgLabel.setText("Error!");
//                    }
//                }
//
//                @Override
//                public void onError(Request request, Throwable exception) {
//                    errorMsgLabel.setText("Sending request failed!");
//                }
//            });
//
//        } catch (RequestException e) {
//            errorMsgLabel.setText("Request exception!");
//        }
//    }
//
//
//}


