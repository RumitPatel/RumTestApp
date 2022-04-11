package com.etl.rum.rumtestapp.stripeTest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.CardInputWidget;

/**
 * Created by FatehAli Asamadi on 2/2/2018.
 * StripeTestActivity
 */

public class StripeTestActivity extends AppCompatActivity {

    private Context mContext;

    private CardInputWidget mCardInputWidget;
    private Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe_test);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;

        mCardInputWidget = findViewById(R.id.card_input_widget);
        btnNext = findViewById(R.id.btn_next);
    }

    private void setListeners() {
        mCardInputWidget.setCardInputListener(new CardInputListener() {
            @Override
            public void onFocusChange(String s) {
                checkValid();
            }

            @Override
            public void onCardComplete() {

            }

            @Override
            public void onExpirationComplete() {
            }

            @Override
            public void onCvcComplete() {
                checkValid();
            }

            @Override
            public void onPostalCodeComplete() {
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getToken();
            }
        });
    }

    private void checkValid() {
        Card cardToSave = mCardInputWidget.getCard();
        if (cardToSave == null || !cardToSave.validateCard()) {
            btnNext.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
        }
    }

    private void getToken() {
        Stripe stripe = new Stripe(mContext, "pk_test_KcWOFVAkLzDW09oBISVqCKfV");
        stripe.createToken(mCardInputWidget.getCard(), new TokenCallback() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "onError", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Token token) {
                Toast.makeText(mContext, "onSuccess, token = " + token.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}