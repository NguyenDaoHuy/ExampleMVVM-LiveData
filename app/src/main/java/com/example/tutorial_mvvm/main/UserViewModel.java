package com.example.tutorial_mvvm.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tutorial_mvvm.R;
import com.example.tutorial_mvvm.model.Person;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<Person>> mListPersonLiveData;
    private List<Person> mPersonList;

    public UserViewModel(){
        mListPersonLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mPersonList = new ArrayList<>();
        mPersonList.add(new Person(R.drawable.test_img,"Huy 0","Huy Title 0"));
        mListPersonLiveData.setValue(mPersonList);
    }

    public MutableLiveData<List<Person>> getListPersonLiveData() {
        return mListPersonLiveData;
    }

    public void addUser(Person person){
        mPersonList.add(0,person);
        mListPersonLiveData.setValue(mPersonList);
    }
}
