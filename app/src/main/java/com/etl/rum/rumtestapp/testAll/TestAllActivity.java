package com.etl.rum.rumtestapp.testAll;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;

/**
 * Created by FatehAli Asamadi on 2/8/2018.
 * TestAllActivity
 */

public class TestAllActivity extends AppCompatActivity {

    private Context mContext;

    private WebView webView;

    private TableRow tableRow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_all);
//        setContentView(R.layout.xxxx);

        mContext = this;

        initComponents();
        setListeners();
    }

    private void initComponents() {
//        webView = findViewById(R.id.web_view);
        tableRow = findViewById(R.id.tableRow);

    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                abc();
                testStarActivityForResult();
            }
        });
    }

    private void testStarActivityForResult() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("maincommentcount", 10);
        returnIntent.putExtra("maincommentposition", 20);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("maincommentcount", 10);
        returnIntent.putExtra("maincommentposition", 20);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
//        super.onBackPressed();
    }

    private void abc() {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TableRow.LayoutParams params1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, (float) 6);
        params1.gravity = Gravity.CENTER;
        linearLayout.setLayoutParams(params1);
        linearLayout.setGravity(Gravity.CENTER);

        TextView h1 = new TextView(mContext);
        h1.setText("50K");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, (float) 0.9);
        h1.setLayoutParams(params);
        h1.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        h1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        ImageView cash = new ImageView(mContext);
        params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, (float) 0.1);
        params.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
        cash.setLayoutParams(params);
        cash.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        linearLayout.addView(h1);
        linearLayout.addView(cash);
        tableRow.addView(linearLayout);
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_xx);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);

        dialog.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private class Seat {
        private int top;
        private int left;

        public int getIntTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getIntLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }
    }

    class CoupenInfo {
        String upc;
        String code;
        String category;
        float itemPrice;
        float couponAmount;

        public String getUpc() {
            return upc;
        }

        public void setUpc(String upc) {
            this.upc = upc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public float getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(float itemPrice) {
            this.itemPrice = itemPrice;
        }

        public float getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(float couponAmount) {
            this.couponAmount = couponAmount;
        }
    }
}