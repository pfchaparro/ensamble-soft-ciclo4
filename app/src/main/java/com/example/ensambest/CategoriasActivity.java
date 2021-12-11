package com.example.ensambest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CategoriasActivity extends AppCompatActivity {

    ArrayList<ProductosCar> listProductos2;
    RecyclerView recycler2;
    MyAdapter2 myAdapter2;
    FirebaseFirestore db2;
    ProgressDialog progressDialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        progressDialog2 = new ProgressDialog(this);
        progressDialog2.setCancelable(false);
        progressDialog2.setMessage("Procesando Datos");
        progressDialog2.show();

        recycler2 = findViewById(R.id.recyclerCat);
        recycler2.setHasFixedSize(true);
        recycler2.setLayoutManager(new LinearLayoutManager(this));

        db2 = FirebaseFirestore.getInstance();
        listProductos2 = new ArrayList<ProductosCar>();
        myAdapter2 = new MyAdapter2(CategoriasActivity.this,listProductos2);

        recycler2.setAdapter(myAdapter2);
        EvenChangeListener();

    }

    private void EvenChangeListener() {
        db2.collection("CARRITO").orderBy("nombre", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){

                            if(progressDialog2.isShowing())
                                progressDialog2.dismiss();

                            Log.e("Firestore Error",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc:value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                listProductos2.add(dc.getDocument().toObject(ProductosCar.class));
                            }

                            myAdapter2.notifyDataSetChanged();
                            if(progressDialog2.isShowing())
                                progressDialog2.dismiss();
                        }
                    }
                });

    }
}