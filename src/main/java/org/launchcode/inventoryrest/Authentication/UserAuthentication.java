package org.launchcode.inventoryrest.Authentication;

public class UserAuthentication {
    private String message;

    @Override
    public String toString() {
        return super.toString();
    }

    public UserAuthentication(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
