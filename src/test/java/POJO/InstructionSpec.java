package POJO;

import Utility.Constants;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Date;

public class InstructionSpec {

    private String instructionReference;
    private String customerReference;
    private double amount;
    private String currency;
    private String country;
    private String settleByDate;
    private String direction;
    private String schemeID;

    public String getInstructionReference() {
        return instructionReference;
    }

    public void setInstructionReference(String instructionReference) {
        if (instructionReference.isEmpty()){
            throw new java.lang.RuntimeException("Instruction Reference is mandatory and cannot be blank hence not allowed");
        }else if (instructionReference.length() > 50){
            throw new java.lang.RuntimeException("Instruction Reference must be less than 50 characters hence not allowed");
        } else
        this.instructionReference = instructionReference;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        if (customerReference.isEmpty()){
            throw new java.lang.RuntimeException("Customer Reference is mandatory and cannot be blank hence not allowed");
        }else if (customerReference.length() > 50){
            throw new java.lang.RuntimeException("Customer Reference must be less than 50 characters hence not allowed");
        } else
            this.customerReference = customerReference;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0){
            throw new java.lang.RuntimeException("Amount cannot be negative hence not allowed");
        }else {
            DecimalFormat df = new DecimalFormat("0.00");
            String a = df.format(amount);
            amount = Double.parseDouble(a);
            this.amount = amount;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(currency.isEmpty()){
            throw new java.lang.RuntimeException("Currency cannot be empty hence not allowed");
        }
        else if (!currency.equalsIgnoreCase("euro"))
            throw new java.lang.RuntimeException("Currency is not Euro hence not allowed");
        else
        currency = "EUR";

        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(!country.equalsIgnoreCase("Ireland")){
            throw new java.lang.RuntimeException("Country is not Ireland hence not allowed");
        }
        else
            country = "IE";

            this.country = country;
    }

    public String getSettleByDate() {
        return settleByDate;
    }

    public void setSettleByDate() {
        String settleByDate = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(settleByDate);
        settleByDate = simpleDateFormat.format(new Date());
        this.settleByDate = settleByDate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if (!direction.equals("DEBIT")){
            throw new java.lang.RuntimeException("Direction is not 'DEBIT' hence is not valid");
        }
        this.direction = direction;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(String schemeID) {
        if (schemeID.isEmpty()){
            throw new java.lang.RuntimeException("SCHEME_ID is not valid hence not allowed");
        }
        else if (!schemeID.equals(Constants.SCHEME_ID)){
            throw new java.lang.RuntimeException("SCHEME_ID is not valid hence not allowed");
        }
        this.schemeID = schemeID;
    }
}
