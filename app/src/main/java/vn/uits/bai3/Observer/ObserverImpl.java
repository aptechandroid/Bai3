package vn.uits.bai3.Observer;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/14/18.
 */

public class ObserverImpl implements Subject {

    private String mFullName;
    private int mAge;

    private static ObserverImpl mObserverObject;
    private List<RepositoryObserver> mObservers;

    // create singleton
    public synchronized static ObserverImpl getInstance() {
        if (mObserverObject == null) {
            mObserverObject = new ObserverImpl();
        }
        return mObserverObject;
    }

    private ObserverImpl() {
        mObservers = new ArrayList<>();
        getNewDataFromRemote();
    }

    // Simulate network
    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setData("Chike Mgbemena", 101);
            }
        }, 10000);
    }

    private void setData(String name, int age) {
        this.mFullName = name;
        this.mAge = age;
        notifyObservers();
    }

    @Override
    public void registerObserver(RepositoryObserver repositoryObserver) {
        if (!mObservers.contains(repositoryObserver)) {
            mObservers.add(repositoryObserver);
        }
    }

    @Override
    public void removeObserver(RepositoryObserver repositoryObserver) {
        if (mObservers.contains(repositoryObserver)) {
            mObservers.remove(repositoryObserver);
        }
    }

    @Override
    public void notifyObservers() {
        for (RepositoryObserver observer : mObservers) {
            observer.onUserDataChanged(mFullName, mAge);
        }
    }
}
