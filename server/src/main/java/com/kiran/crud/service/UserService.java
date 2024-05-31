package com.kiran.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.kiran.crud.entity.SubjectMarks;
import com.kiran.crud.entity.User;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

	 private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	    public List<User> getAll() throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        QuerySnapshot querySnapshot = dbFirestore.collection("users").get().get();

	        List<User> userList = new ArrayList<>();
	        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
	            userList.add(document.toObject(User.class));
	        }
	        return userList;
	    }

	    public User getUserById(String userId) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentSnapshot document = dbFirestore.collection("users").document(userId).get().get();
	        if (document.exists()) {
	       
	            return document.toObject(User.class);
	        } else {
	            return null;
	        }
	    }

	    public String createUser(User userData) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(userData.getId()).set(userData);

	        try {
	            return writeResult.get().getUpdateTime().toString();
	        } catch (InterruptedException | ExecutionException e) {
	            LOGGER.log(Level.SEVERE, "Error creating user in Firestore", e);
	            throw e;
	        }
	    }

	    public String updateUser(String id, User updatedUser) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentReference userRef = dbFirestore.collection("users").document(id);
	        
	        Map<String, Object> updates = new HashMap<>();
	        if (updatedUser.getName() != null) {
	            updates.put("name", updatedUser.getName());
	        }
	        if (updatedUser.getSubjectMarks() != null) {
	            SubjectMarks subjectMarks = updatedUser.getSubjectMarks();
	            if (subjectMarks.getMath() != 0) {
	                updates.put("subjectMarks.math", subjectMarks.getMath());
	            }
	            if (subjectMarks.getPhysics() != 0) {
	                updates.put("subjectMarks.physics", subjectMarks.getPhysics());
	            }
	            if (subjectMarks.getChemistry() != 0) {
	                updates.put("subjectMarks.chemistry", subjectMarks.getChemistry());
	            }
	            if (subjectMarks.getBiology() != 0) {
	                updates.put("subjectMarks.biology", subjectMarks.getBiology());
	            }
	            if (subjectMarks.getMarathi() != 0) {
	                updates.put("subjectMarks.marathi", subjectMarks.getMarathi());
	            }
	            if (subjectMarks.getEnglish() != 0) {
	                updates.put("subjectMarks.english", subjectMarks.getEnglish());
	            }
	            
	        }

	        ApiFuture<WriteResult> writeResult = userRef.update(updates);

	        try {
	            return writeResult.get().getUpdateTime().toString();
	        } catch (InterruptedException | ExecutionException e) {
	            LOGGER.log(Level.SEVERE, "Error updating user in Firestore", e);
	            throw e;
	        }
	    }

	    public String deleteUserById(String id) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(id).delete();

	        try {
	            return "User with ID " + id + " deleted successfully.";
	        } catch (Exception e) {
	            LOGGER.log(Level.SEVERE, "Error deleting user in Firestore", e);
	            throw e;
	        }
	    }

}
