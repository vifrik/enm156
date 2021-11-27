package model.vasttrafik_api.response_classes.name;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import model.vasttrafik_api.response_classes.AlwaysListTypeAdapterFactory;

public class LocationList{

	@SerializedName("serverdate")
	private String serverdate;

	@SerializedName("servertime")
	private String servertime;

	@SerializedName("noNamespaceSchemaLocation")
	private String noNamespaceSchemaLocation;

	@SerializedName("StopLocation")
	@JsonAdapter(AlwaysListTypeAdapterFactory.class)
	private List<StopLocationItem> stopLocation;

	@SerializedName("CoordLocation")
	@JsonAdapter(AlwaysListTypeAdapterFactory.class)
	private List<CoordLocationItem> coordLocation;

	public String getServerdate(){
		return serverdate;
	}

	public String getServertime(){
		return servertime;
	}

	public String getNoNamespaceSchemaLocation(){
		return noNamespaceSchemaLocation;
	}

	public List<StopLocationItem> getStopLocation(){
		return stopLocation;
	}

	public List<CoordLocationItem> getCoordLocation(){
		return coordLocation;
	}
}