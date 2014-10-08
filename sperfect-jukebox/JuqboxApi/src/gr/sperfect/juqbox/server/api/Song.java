package gr.sperfect.juqbox.server.api;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Song {
	@Id Long id;
	private String url;
	private String name;

	 protected Song() {}

	public Song(String name, String url) {
		this.name = name;
		this.url = url;
	};
	 
}
