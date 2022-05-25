package com.etl.rum.rumtestapp.cNetPay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cinetpay.sdk.MerchantService;
import com.cinetpay.sdk.PaymentResponse;
import com.cinetpay.sdk.Purchase;
import com.cinetpay.sdk.process.CinetPay;
import com.cinetpay.sdk.ui.CinetPayUI;
import com.etl.rum.rumtestapp.R;

import java.util.Date;

public class CNEtPayActivity extends AppCompatActivity {

    private String API_KEY = "189643";
    private String SITE_ID = "15441540385c73e0face0885.86769926";

    private MerchantService CINETPAY_MERCHANT = new MerchantService(API_KEY, SITE_ID);
    private MerchantService CINETPAY_MERCHANT_WITH_URL_NOTIFICATION =
            new MerchantService(API_KEY, SITE_ID, "http://mhealthcareinfotech.com/zency/admin_zency/index.php/cinetpayment/success", false);

    private EditText mAmountView;
    private Button mPayView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnet_pay);

        mAmountView = findViewById(R.id.amount);
        mPayView = findViewById(R.id.pay);

        mPayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = mAmountView.getText().toString();

                if (amount.isEmpty()) {

                } else {
//                    CinetPayUI cinetPayUI = CinetPayUI.getInstance(CNEtPayActivity.this, CINETPAY_MERCHANT);
                    CinetPayUI cinetPayUI = CinetPayUI.getInstance(CNEtPayActivity.this, CINETPAY_MERCHANT_WITH_URL_NOTIFICATION);

                    Purchase purchase = new Purchase();
                    purchase.setMetaData("custom");
                    purchase.setReference(String.valueOf(new Date().getTime()));
                    purchase.setDescription("Ma description");
                    purchase.setTitle("Test paiement");
                    purchase.setAmount(Integer.valueOf(amount));

                    cinetPayUI.beginPayment(purchase, new CinetPay.PayCallBack() {
                        @Override
                        public void onPurchaseComplete(PaymentResponse response, Purchase purchase) {
                            if (response.getCode().equals("00") && response.hasBeenAccepted()
                                    && response.hasBeenConfirmed()) {
                                // Paiement effectué avec succès
                                System.out.println("success");
                            } else {
                                System.out.println("fail");
                            }
                        }
                    });
                }
            }
        });
    }
}