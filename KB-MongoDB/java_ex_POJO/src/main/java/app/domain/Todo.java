package app.domain;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	private ObjectId id;
	private String title;
	private String desc;
	private boolean done;
}
