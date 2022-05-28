package com.etl.rum.rumtestapp.directPay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import com.etl.rum.rumtestapp.R;
import com.toml.dp.util.AES128Bit;

/**
 * Created by FatehAli Asamadi on 1/4/2018.
 * DirecPayTestActivity
 */

public class DirecPayTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directpay_test);

        findViewById(R.id.btn_click_here).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpDirecPay();
            }
        });
    }

    private void setUpDirecPay() {
        String url = "https://test.timesofmoney.com/direcpay/secure/dpMerchantPayment.jsp";
//        String url = "http://test.timesofmoney.com/direcpay/secure/dpMerchantTransaction.jsp";

        String Key = "qcAHa6tt8s0l5NN7UWPVAQ==";
//        String Key = "9H90uuwRH/7nZqrAuD3FhQ==";

//        String MID = "201603111000003";
        String MID = "200904281000001";


        String Operating_Mode = "DOM";
        String Country = "IND";
        String Currency = "INR";
        String Amount = "100.00";
        String Merchant_Order_No = "test-order";
        String Other_Details = "others";
        String Success_URL = "www.url.com/success.html";
        String Failure_URL = "www.url.com/fail.html";
        String Collaborator = "TOML";


        String requestparameter = MID + "|" +
                Operating_Mode + "|" +
                Country + "|" +
                Currency + "|" +
                Amount + "|" +
                Merchant_Order_No + "|" +
                Other_Details + "|" +
                Success_URL + "|" +
                Failure_URL + "|" +
                Collaborator;

        String custName = "TestUser";
        String custAddress = "Mumbai";
        String custCity = "Mumbai";
        String custState = "Maharashtra";
        String custPinCode = "400001";
        String custCountry = "IN";
        String custPhoneNo1 = "91";
        String custPhoneNo2 = "022";
        String custPhoneNo3 = "28000000";
        String custMobileNo = "9820000000";
        String custEmailId = "testuser@gmail.com";
        String otherNotes = "test transaction for direcpay";
        String billingDtls = custName + "|" +
                custAddress + "|" +
                custCity + "|" +
                custState + "|" +
                custPinCode + "|" +
                custCountry + "|" +
                custPhoneNo1 + "|" +
                custPhoneNo2 + "|" +
                custPhoneNo3 + "|" +
                custMobileNo + "|" +
                custEmailId + "|" +
                otherNotes;

        String deliveryName = "TestUser";
        String deliveryAddress = "Mumbai";
        String deliveryCity = "Mumbai";
        String deliveryState = "Maharashtra";
        String deliveryPinCode = "400234";
        String deliveryCountry = "IN";
        String deliveryPhNo1 = "91";
        String deliveryPhNo2 = "022";
        String deliveryPhNo3 = "28000000";
        String deliveryMobileNo = "9920000000";
        String shippingDtls = deliveryName + "|" +
                deliveryAddress + "|" +
                deliveryCity + "|" +
                deliveryState + "|" +
                deliveryPinCode + "|" +
                deliveryCountry + "|" +
                deliveryPhNo1 + "|" +
                deliveryPhNo2 + "|" +
                deliveryPhNo3 + "|" +
                deliveryMobileNo;


        MID = AES128Bit.encrypt(MID, Key);
        requestparameter = AES128Bit.encrypt(requestparameter, Key);
        billingDtls = AES128Bit.encrypt(billingDtls, Key);
        shippingDtls = AES128Bit.encrypt(shippingDtls, Key);

        requestparameter = requestparameter.replaceAll("\n", "");
        billingDtls = billingDtls.replaceAll("\n", "");
        shippingDtls = shippingDtls.replaceAll("\n", "");

        openWebViewWithPostParams(url, MID, requestparameter, billingDtls, shippingDtls);
    }

    private void openWebViewWithPostParams(String url, String merchentId, String requestParams, String billingDetails, String shippingDetails) {
        WebView webview = findViewById(R.id.web_view);
        /*String postData = null;
        try {
            postData = "requestparameter=" + URLEncoder.encode(requestParams, "UTF-8") +
                    "&billingDtls=" + URLEncoder.encode(billingDetails, "UTF-8") +
                    "&shippingDtls=" + URLEncoder.encode(shippingDetails, "UTF-8") +
                    "&merchantId=" + URLEncoder.encode(merchentId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        webview.postUrl(url, postData.getBytes());*/


        String html = "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "<form name='ecom' method='post' action='" + url + "'>" +
                "  <input type='hidden' name='requestparameter' value='" + requestParams + "'><br>" +
                "  <input type='hidden' name='billingDtls' value='" + billingDetails + "'><br>" +
                "  <input type='hidden' name='shippingDtls' value='" + shippingDetails + "'><br>" +
                " <input type='hidden' name='merchantId' value ='" + merchentId + "'/>" +
                "<input type='submit' name='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
        webview.loadData(html, "text/html", "UTF-8");


/*        webview.loadDataWithBaseURL("www.mobichem.com/index.php/securedp/standard/redirect/",
                html,
                "text/html",
                "UTF-8",
                "");*/


/*        String postData = "requestparameter=" + requestParams +
                "&billingDtls=" + billingDetails +
                "&shippingDtls=" + shippingDetails +
                "&merchantId=" + merchentId;
        webview.postUrl(url, EncodingUtils.getBytes(postData, "BASE64"));*/




/*        Map<String, String> extraHeaders = new HashMap<String, String>();
        extraHeaders.put("referer", "www.mobichem.com/index.php/securedp/standard/redirect/");
        webview.loadUrl(html, extraHeaders);*/

    }
}