package com.example.analytag;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class TagCollection extends RealmObject {
	private String title;
	private RealmList<String> tags;

	public TagCollection() {}

	public TagCollection(String title) {
		this.title = title;
		this.tags = new RealmList<>();
	}

	public TagCollection(String title, ArrayList<String> newTags) {
		this.title = title;
		tags.addAll(newTags);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag(int i) {
		try{
			return tags.get(i);
		}
		catch(IndexOutOfBoundsException e) {
			return "";
		}
	}

	public boolean addTag(String tag) {
		if(tag.charAt(0) == '#')
			tag = tag.substring(1);

		if (tags.contains(tag) || tag.isEmpty())
			return false;
		else
			tags.add(tag);
		return true;
	}

	public boolean removeTag(String tag) {
		return tags.remove(tag);
	}

	public void removeTags() {
		tags.clear();
	}

	public RealmList<String> getTags() {
		return tags;
	}

	public int getTagCount() {
		return tags.size();
	}

	@Override
	public String toString() {
		//return title + " - " + tags;
		StringBuilder sb = new StringBuilder();
		sb.append(title).append(" - ");
		for(String t : tags)
			sb.append(t).append(", ");

		return sb.toString();
	}
}