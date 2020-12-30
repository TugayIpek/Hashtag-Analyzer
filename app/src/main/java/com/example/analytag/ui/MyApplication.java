package com.example.analytag.ui;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Realm.init(this);
		RealmConfiguration realmConfig = new RealmConfiguration.Builder()
				.name("AnalyTag.realm")
				.deleteRealmIfMigrationNeeded()
				.build();
		Realm.setDefaultConfiguration(realmConfig);
	}
}
