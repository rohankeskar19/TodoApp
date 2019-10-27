package models;


public class TodoModel {
	String id,username,created_at,content,due,completed;

	public TodoModel(String id, String created_at, String content, String due,String completed) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.content = content;
		this.due = due;
		this.completed = completed;
	}

	
	public String getCompleted() {
		return completed;
	}


	public void setCompleted(String completed) {
		this.completed = completed;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}


	@Override
	public String toString() {
		return "TodoModel [id=" + id + ", username=" + username + ", created_at=" + created_at + ", content=" + content
				+ ", due=" + due + ", completed=" + completed + "]";
	}

	
	 
	
	
	
}
