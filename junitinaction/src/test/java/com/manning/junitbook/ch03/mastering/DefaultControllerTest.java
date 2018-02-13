package com.manning.junitbook.ch03.mastering;

import org.junit.Before;
import org.junit.Ignore;
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
        assertEquals("should be equals", new SampleResponse(), response);

    }

    @Test
    public void testProcessRequestAnswerErrorResponse() {
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        defaultController.addHandler(request, handler);
        Response response = defaultController.processRequest(request);
        assertNotNull("must not be null", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");
        //this line should throw error
        defaultController.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicatedName() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        //this line should throw error
        defaultController.addHandler(request, handler);
    }

    @Test(timeout = 130)
    @Ignore(value = "ignore test sample")
    public void testProcessMultipleRequestTimeout() {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();

        for (int i = 0; i < 9999; i++) {
            request = new SampleRequest(String.valueOf(i));
            defaultController.addHandler(request, handler);
            response = defaultController.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

    //region TestObjects
    private class SampleRequest implements Request {
        public static final String DEFAULT_NAME = "Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this.name = DEFAULT_NAME;
        }

        public String getName() {
            return this.name;
        }
    }

    private class SampleHandler implements RequestHandler {

        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        public static final String NAME = "Test";

        public String getName() {
            return NAME;
        }

        public boolean equals(Object object) {
            boolean result = false;
            if (object instanceof SampleResponse) {
                result = ((SampleResponse) object).getName().equals(getName());
            }
            return result;
        }

        public int hashCode() {
            return NAME.hashCode();
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }
    //endregion
}