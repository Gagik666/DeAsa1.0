package com.example.deasa10.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.deasa10.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
//    private lateinit var mAuth: FirebaseAuth
//    private lateinit var refUsers: DatabaseReference
//    var fireBaseUserId: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        mAuth = FirebaseAuth.getInstance()
////        binding.btnRegistration.setOnClickListener {
////            registerUser()
////        }
//
//    }

//    fun registerUser() {
//        val email: String = binding.edEmail.text.toString()
//        val password: String = binding.edPassvord.text.toString()
//
//        if (email == "") {
//            Toast.makeText(context, "email is empty", Toast.LENGTH_SHORT).show()
//        } else if (password == "") {
//            Toast.makeText(context, "password is empty", Toast.LENGTH_SHORT).show()
//        } else {
//            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { Task ->
//                if (Task.isSuccessful) {
//                    fireBaseUserId = mAuth.currentUser!!.uid
//                    refUsers = FirebaseDatabase.getInstance().reference.child("Users")
//                        .child(fireBaseUserId)
//                    var userHashMap = HashMap<String, Any>()
//                    userHashMap["uid"] = fireBaseUserId
//                    userHashMap["email"] = email
//
//                    refUsers.updateChildren(userHashMap).addOnCompleteListener { Task ->
//                        if (Task.isSuccessful) {
//                            Toast.makeText(context, "Stacvec", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            }
//        }
//    }
}