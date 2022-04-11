package com.etl.rum.rumtestapp.googleSheetAccess;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class GoogleSheetAccessActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Sheets createSheetsService() {
//        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        // TODO: Change placeholder below to generate authentication credentials. See
        // https://developers.google.com/sheets/quickstart/java#step_3_set_up_the_sample
        //
        // Authorize using one of the following scopes:
        //   "https://www.googleapis.com/auth/drive"
        //   "https://www.googleapis.com/auth/drive.file"
        //   "https://www.googleapis.com/auth/drive.readonly"
        //   "https://www.googleapis.com/auth/spreadsheets"
        //   "https://www.googleapis.com/auth/spreadsheets.readonly"
        GoogleCredential credential = null;

        return new Sheets.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName("Google-SheetsSample/0.1")
                .build();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sheet_access);

        setListener();
    }

    private void setListener() {
        findViewById(R.id.btnAddData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addBulkData();
            }
        });

        findViewById(R.id.btnRetriveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findViewById(R.id.btnRetriveDataFromSheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                try {
                    importFromExcel();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }*/

//                new RetrieveFeedTask().execute();

                workBook();
            }
        });
    }

    private void importFromExcel() throws IOException {
        // The spreadsheet to request.
        String spreadsheetId = "1aBwpNMOJpOCLuGJ1AVKFKdbnHrlyBdRHAbsj0hGiOaw";

        // The ranges to retrieve from the spreadsheet.
        List<String> ranges = new ArrayList<>();

        // True if grid data should be returned.
        // This parameter is ignored if a field mask was set in the request.
        boolean includeGridData = false; // TODO: Update placeholder value.

        Sheets sheetsService = createSheetsService();
        Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(spreadsheetId);
        request.setRanges(ranges);
        request.setIncludeGridData(includeGridData);

        Spreadsheet response = request.execute();
        System.out.println(response);

    }

    private void workBook() {
        try {

            AssetManager am = getAssets();// If this line gives you ERROR then try AssetManager am=getActivity().getAssets();
            InputStream is = am.open("torab.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();
            String xx = "";
            for (int i = 0; i < row; i++) {
                for (int c = 0; c < col; c++) {
                    Cell z = s.getCell(c, i);
                    xx = xx + z.getContents();

                }
                xx = xx + "\n";
            }
            display(xx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display(String value) {
        TextView x = findViewById(R.id.textView);
        x.setText(value);
    }

    private class RetrieveFeedTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
/*            try {
//                importFromExcel();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }*/
            return null;
        }
    }

}