package gr.sperfect.jukebox.web.core.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Song {

	@Id public Long id;
    @Index public String url;
    
    public Song(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
		
	}
}
