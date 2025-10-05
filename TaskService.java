package mod4milestone;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
/*
    The task service shall be able to add tasks with a unique ID.
    The task service shall be able to delete tasks per task ID.
    The task service shall be able to update task fields per task ID. The following fields are updatable:
        Name
        Description
 */


//FIXME: Should turn into a Singleton pattern later
public class TaskService {
	private final long maxTaskIdSize = 9999999999L;
	private Map<Long, Task> taskList = new HashMap<>();
	
	private AtomicLong currentUniqueId = new AtomicLong(1); //thread safe increment
	
	
	public TaskService() {
		
	}
	
	
	public void addTask(String name, String description) throws IllegalArgumentException, RuntimeException{
		if(this.currentUniqueId.get() >= this.maxTaskIdSize) {
			throw new RuntimeException("Max size of contact list exceeded");
		}
		
		try {
			Task tempTask = new Task(Long.toString(this.currentUniqueId.get()), name, description);
			taskList.putIfAbsent(this.currentUniqueId.get(), tempTask);	//values cant get overwrote
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException(exception);
		}
		
		this.currentUniqueId.getAndIncrement(); //does nothing with the 'get'
		
	}
	
	public void removeTask(long taskId) throws RuntimeException {
		if (taskList.containsKey(taskId)) {
			taskList.remove(taskId);
			return;
		}
		throw new RuntimeException("Value not found");
	}
	
	public void updateName(long taskId, String name) throws RuntimeException {
		if(taskList.containsKey(taskId)) {
			taskList.get(taskId).setName(name);
			return;
		}
		throw new RuntimeException("Value not found");
	}
	
	public void updateDescription(long taskId, String description) throws RuntimeException {
		if(taskList.containsKey(taskId)) {
			taskList.get(taskId).setDescription(description);
			return;
		}
		throw new RuntimeException("Value not found");
	}
	
	//get task at key
	public Task getTask(long taskId) throws RuntimeException {
		if(taskList.containsKey(taskId)) {
			return taskList.get(taskId);
		}
		throw new RuntimeException("Value not found");
	}
	
	
	//get task as string
	public String getTaskInfo(long taskId) throws RuntimeException {
		if(taskList.containsKey(taskId)) {
			return taskList.get(taskId).toString();
		}
		throw new RuntimeException("Value not found");
	}
	
	//FIXME: Method only for testing
	public long getCurrentId() {
		return this.currentUniqueId.get();
	}
	
	
	
}
