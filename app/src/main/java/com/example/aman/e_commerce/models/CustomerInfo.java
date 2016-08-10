package com.example.aman.e_commerce.models;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Aman on 07-Aug-16.
 */
public class CustomerInfo extends RealmObject{
public String cName;
public String cPassword;
public String cPhoneNo;
public String cEmail;
public String cAddress;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcPhoneNo() {
        return cPhoneNo;
    }

    public void setcPhoneNo(String cPhoneNo) {
        this.cPhoneNo = cPhoneNo;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "cName='" + cName + '\'' +
                ", cPassword='" + cPassword + '\'' +
                ", cPhoneNo='" + cPhoneNo + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cAddress='" + cAddress + '\'' +
                '}';
    }
}
