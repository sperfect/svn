package gr.sperfect.juqbox.server.api;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Room {

	@Id
	Long id;
	@Index
	String name;
	String url;
	Date dateCreated;
	
	@Load
	private Ref<SongList> songlist;
	@Load
	private Ref<User> creator;

	private Room() {
	};

	public Room(User creator) {
		setCreator(creator);
		dateCreated = new Date(); 
	}

	public User getCreator() {
		return creator.get();
	}

	public void setCreator(User creator) {
		this.creator = Ref.create(creator);
	}

	public SongList getSongList() {
		if (songlist == null)
			return null;
		return songlist.get();
	}

	public void setSonglist(SongList songlist) {
		this.songlist = Ref.create(songlist);
	}

}
