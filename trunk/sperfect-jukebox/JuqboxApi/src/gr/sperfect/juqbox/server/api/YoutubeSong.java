package gr.sperfect.juqbox.server.api;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index=true)
public class YoutubeSong extends Song {

	public YoutubeSong(String name, String url) {
		super(name,url);
	};

	 
}
