package com.example.autowireannotation;

import org.springframework.stereotype.Component;

@Component
public class Payment {

    private String providerName ="Paypal";

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    private String printHello ()
    {
        return "hello..";
    }

    public String toString(){
        return "Payment{" + "providername=" +providerName+ '\'' +'}';
    }
}
