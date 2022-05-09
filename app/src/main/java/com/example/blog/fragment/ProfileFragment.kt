package com.example.blog.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.blog.LoginActivity
import com.example.blog.R
import com.example.blog.data.ReadProfile
import com.example.blog.databinding.FragmentHomeBinding
import com.example.blog.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.StorageReference
import io.grpc.Context
import java.util.*
import kotlin.concurrent.timerTask

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var mAuth : FirebaseAuth

    //14/4/2022
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid:String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root

//        mAuth = FirebaseAuth.getInstance()
//
//        uid = mAuth.currentUser?.uid.toString()
//
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//        if (uid.isNotEmpty()){
//            getUserData()
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                buildDialog()!!.show()

            }

        })

    }
    private fun buildDialog(): AlertDialog.Builder? {
        val builder = AlertDialog.Builder(binding.root.context)
        builder.setTitle("Delete comment")
        builder.setMessage("Do you want to delete this comment?")
        builder.setPositiveButton("Logout") { dialog, which ->
            mAuth.signOut()
            val intent = Intent(activity,LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        builder.setNeutralButton("Cancel") { dialog, which -> }
        return builder
    }

    private fun getUserData(){
//        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                user = snapshot.getValue(User::class.java)!!
////                binding.tvFullName.setText(user.)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })








//        val databaseReference = FirebaseDatabase.getInstance().getReference("User")
//        val profileList = java.util.ArrayList<ReadProfile>()
//        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot){
//                if (snapshot.exists()){
//                    for (uSnapshot in snapshot.children) {
//                        val data = uSnapshot.getValue(ReadProfile::class.java)
//                        profileList.add(data!!)
//                        Glide.with(binding.root).load(profileList[0].userAvatar)
//                            .into(imvAvatar)
//                        tvName.setText(profileList[0].userName.toString())
//
//                    }
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.d("DatabaseError", error.message)
//            }
//
//        })








    }
}