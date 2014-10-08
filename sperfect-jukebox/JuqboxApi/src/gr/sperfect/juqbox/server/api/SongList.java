package gr.sperfect.juqbox.server.api;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class SongList {

	@Id Long id;

	 SongList() {};
	 
	 @Load
	 List<Ref<Song>> subordinates = new ArrayList<Ref<Song>>();

}
