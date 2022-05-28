package com.etl.rum.rumtestapp.fireStoreTest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FireStoreTestActivity extends AppCompatActivity {

    private static final String COLLECTION_NAME = "users";
    private static final String TAG = "m_tag";
    private FirebaseFirestore db;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firestore_test);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;
        db = FirebaseFirestore.getInstance();
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        findViewById(R.id.btnClickHereRetrive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveUser();
            }
        });

        setListenersForDocumentChange();
    }

    private void createUser() {
        // Create a new user with a first, middle, and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Rishil");
        user.put("middle", "A");
        user.put("last", "Patel");
        user.put("born", 1912);


// Add a new document with a generated ID
        db.collection(COLLECTION_NAME)
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(mContext, "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(mContext, "Error adding document", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void retriveUser() {
        db.collection(COLLECTION_NAME)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.e(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Toast.makeText(mContext, "Error getting documents.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void setListenersForDocumentChange() {
        /*CollectionReference colRef = db.collection(COLLECTION_NAME);
        colRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if(documentSnapshots != null && !documentSnapshots.isEmpty()) {
                    List<DocumentChange> listDocumentChanges = documentSnapshots.getDocumentChanges();
                    for (int i = 0; i < listDocumentChanges.size(); i++) {
                        DocumentChange documentChange = listDocumentChanges.get(i);
                        DocumentSnapshot documentSnapshot = documentChange.getDocument();
                        Log.e(TAG, "first = "+documentSnapshot.get("first").toString());
                        Log.e(TAG, "middle = "+documentSnapshot.get("middle").toString());
                        Log.e(TAG, "last = "+documentSnapshot.get("last").toString());
                        Log.e(TAG, "born = "+documentSnapshot.get("born").toString());
                    }
                }
            }
        });*/


        final DocumentReference docRef = db.collection(COLLECTION_NAME).document("JkXOTzDc2hzoyMKKH72r");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.e(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    Log.e(TAG, "Current data: " + snapshot.getData());
                } else {
                    Log.e(TAG, "Current data: null");
                }
            }
        });
    }
}