package gr.sperfect.jukebox.web.core.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Room {

	public Room(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Id public Long id;
    @Index public String name;

}
