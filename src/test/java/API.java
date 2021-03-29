import POJO.InstructionSpec;
import Utility.Constants;
//import com.sun.org.apache.bcel.internal.generic.Instruction;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.text.ParseException;

import static io.restassured.RestAssured.given;


public class API {

    public static void main(String[] args) throws ParseException {

       /* InstructionSpec instruction = new InstructionSpec();
        instruction.setAmount(94.28);
        instruction.setCountry("Ireland");
        instruction.setInstructionReference("This is the instruction reference");
        instruction.setCurrency("Euro");
        instruction.setDirection("DEBIT");
        instruction.setSchemeID(Constants.SCHEME_ID);
        instruction.setSettleByDate();
        instruction.setCustomerReference("This is the customer reference");*/




        RestAssured.baseURI= Constants.REST_BASE_API;
        given().log().all()
                .header("x-account-id", Constants.ACCOUNT_ID)
                .header("x-tenant-id", Constants.TENANT_ID)
                .header("Authorization","bearer "+API.getBearerToken())
                .when().post(Constants.ORDER_MANAGEMENT_ENDPOINT)
                .then().log().all().assertThat().statusCode(201);
    }



    public static String getBearerToken(){
        String accessToken =  given().log().all().header("Authorization","hmac "+Constants.generatesHmac(Constants.PUBLIC_KEY,Constants.PRIVATE_KEY))
                .when().post(Constants.AUTHENTICATION_ENDPOINT)
                .then().assertThat().statusCode(201).extract().path("accessToken");
        return accessToken;
    }
}