package gr.sperfect.juqbox.server.api;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Room {

	@Id
	Long id;

	private Room() {
	};

	@Load
	private Ref<User> creator;

	public User getCreator() {
		return creator.get();
	}

	public void setCreator(User creator) {
		this.creator = Ref.create(creator);
	}

}
