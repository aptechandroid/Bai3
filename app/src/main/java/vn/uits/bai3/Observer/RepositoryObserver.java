package vn.uits.bai3.Observer;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/14/18.
 */

public interface RepositoryObserver {
    void onUserDataChanged(String name, int age);
}
