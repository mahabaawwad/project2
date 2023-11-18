package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMusicFragment extends Fragment {
    private FirebaseServices fbs;
    private EditText etComposerName,etPagesNum ,etYear,etPieceName;
    private Button btnAdd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddMusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddMusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMusicFragment newInstance(String param1, String param2) {
        AddMusicFragment fragment = new AddMusicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_music, container, false);
    }
    public void onStart(){
        super.onStart();
        connectComponents();
    }

    private void connectComponents() {
        fbs=FirebaseServices.getInstance();
        etComposerName=getView().findViewById(R.id.etComposerNameAddmusic);
        etPagesNum=getView().findViewById(R.id.etPagesNumAddmusic);
        etYear=getView().findViewById(R.id.etYearAddmusic);
        etPieceName=getView().findViewById(R.id.etPieceNameAddmusic);
        btnAdd=getView().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo:add data to firebase
                //get data from screen
                String composerName =etComposerName.getText().toString();
                String pagesNum = etPagesNum.getText().toString();
                String year=etYear.getText().toString();
                String pieceName=etPieceName.getText().toString();

                if (composerName.trim().isEmpty()||pagesNum.isEmpty()|| year.trim().isEmpty()||pieceName.trim().isEmpty()){
                    Toast.makeText(getActivity(), "some fields are empty! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                Music rest=new Music(composerName,pagesNum,year,pieceName);
                fbs.getFire().collection("music").add(rest).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "successfully added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddMusic:",e.getMessage());
                    }
                });

            }
        });
    }

}