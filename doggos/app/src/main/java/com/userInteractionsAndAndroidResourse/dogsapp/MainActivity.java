package com.userInteractionsAndAndroidResourse.dogsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.userInteractionsAndAndroidResourse.dogsapp.api.APIResponse;
import com.userInteractionsAndAndroidResourse.dogsapp.api.RetrofitClient;
import com.userInteractionsAndAndroidResourse.dogsapp.model.BreedImageListResponse;
import com.userInteractionsAndAndroidResourse.dogsapp.model.BreedListResponse;
import com.userInteractionsAndAndroidResourse.dogsapp.presenter.Presenter;
import com.userInteractionsAndAndroidResourse.dogsapp.ui.BreedImageListFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Presenter.View {

    private static final String TAG = "MainActivity";
    private Presenter presenter;
    private String choosedbreed;
    private ArrayList<String> dogs;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        presenter = new Presenter(this);

        Button boton = findViewById(R.id.fav);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("favs").orderBy("timestamp", Query.Direction.DESCENDING).get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                ArrayList<String> favdogs = new ArrayList<>();
                                if (task.isSuccessful()) {
                                    QuerySnapshot result = task.getResult();
                                    List<DocumentSnapshot> documents = result.getDocuments();
                                    for (QueryDocumentSnapshot doc : task.getResult()) {
                                        favdogs.add((String) doc.getData().get("url"));
                                        instanceFragment(favdogs);
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "No pudimos conectar a la base de datos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        presenter.getDataForSpinner();

    }

    @Override
    public void instanceFragment(ArrayList<String> dogs){
        BreedImageListFragment detailFragment = BreedImageListFragment.newInstance(dogs);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.vistadogs, detailFragment, "DetailFragment")
                .addToBackStack("Dog")
                .commit();
    }

    @Override
    public void failedRequest() {
        Toast.makeText(this, "No se puede llevar a cabo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setSpinner(final ArrayList<String> dogs) {
        Spinner spinner = findViewById(R.id.tryspinner);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dogs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemSelected: ITEM");
                choosedbreed = dogs.get(position);
                presenter.whoLetTheDogsOut(choosedbreed);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "onNothingSelected: NO ITEM");
            }
        });
    }
}
