package com.precisionbio.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param message
     */
    public HelloWorldBean(String message) {
        this.message = message;
    }

}
