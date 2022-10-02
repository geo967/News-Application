package com.example.secondnewsappmvp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Source class contains the details of source of a news
 *
 * @Param name denotes the name of source
 * @Param id denotes the source id
 */

public class Source {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public String getName() {
		return name;
	}

	public String getId(){
		return id;
	}
}