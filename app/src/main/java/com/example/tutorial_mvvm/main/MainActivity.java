package com.example.tutorial_mvvm.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tutorial_mvvm.R;
import com.example.tutorial_mvvm.databinding.ActivityMain2Binding;
import com.example.tutorial_mvvm.model.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private UserViewModel userViewModel;
    private UserAdapter userAdapter;
    private int index = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rcvUser.setLayoutManager(linearLayoutManager);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getListPersonLiveData().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                userAdapter = new UserAdapter(people);
                binding.rcvUser.setAdapter(userAdapter);
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 clickAddUser();
            }
        });
    }

    private void clickAddUser() {
        Person person = new Person(R.drawable.test_img,"Huy"+index,"Huy Title"+index);
        userViewModel.addUser(person);
        index++;
    }
}