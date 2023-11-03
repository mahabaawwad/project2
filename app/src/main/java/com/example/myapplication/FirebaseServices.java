package com.example.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServices {
    private static FirebaseServices instance ;
    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;

    public  FirebaseServices(){

        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        storage=FirebaseStorage.getInstance();
    }
    public FirebaseServices getInstance(){
        if (instance==null){
            instance=new FirebaseServices();
        }
        return instance;
    }
}