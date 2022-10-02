package com.example.secondnewsappmvp.data.model;

import com.google.gson.annotations.SerializedName;

public class Source{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}
}