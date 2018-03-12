package com.akos.library.client.api;

import com.akos.library.common.entity.Person;
import com.google.gwt.editor.client.Editor;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/library/person")
public interface PersonService extends RestService {

    @GET
    public void getAll(MethodCallback<List<Person>> persons);

    @GET
    @Path("{id}")
    public void get(@PathParam("id") Long id, MethodCallback<Person> person);
}
