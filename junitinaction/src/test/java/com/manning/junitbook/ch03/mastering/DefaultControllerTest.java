package com.manning.junitbook.ch03.mastering;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultControllerTest {

    private DefaultController defaultController;
    private Request request;
    private RequestHandler handler;

    @Before
    public void instantiate() throws Exception {
        defaultController = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();
        defaultController.addHandler(request, handler);
    }

    @Test
    public void testAddHandler() {
        RequestHandler handler1 = defaultController.getHandler(request);
        assertSame("Should be de same handler", handler, handler1);
    }

    @Test
    public void testProcessRequest() {
        Response response = defaultController.processRequest(request);
        assertNotNull("must not be null", response);
        assertEquals("should be sampleresponse class", SampleResponse.class, response.getClass());

    }

    //region TestObjects
    private class SampleRequest implements Request {
        public String getName() {
            return "Test";
        }
    }

    private class SampleHandler implements RequestHandler {

        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {

    }
    //endregion
}