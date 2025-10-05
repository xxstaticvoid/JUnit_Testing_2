package mod4milestone;

/*
 * 
    The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
    The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
    The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.

 */


public class Task {
	
	private final String uniqueTaskId;
	private String name;
	private String description;
	
	
	public Task(String uniqueTaskId, String name, String description) throws IllegalArgumentException {
		
		if(uniqueTaskId == null || name == null || description == null) {
			throw new IllegalArgumentException("Cant instantiate task with null values");
		}
		
		//Verify TaskId is in approved range
		if (uniqueTaskId.length() < 0 || uniqueTaskId.length() > 10) {
			throw new IllegalArgumentException("Cant instantiate task with values outside of expected range");
		} else {
			try {
				long temp = Long.valueOf(uniqueTaskId);
				if(temp < 0) {
					throw new IllegalArgumentException("Cant instantiate task with values outside of expected range");
				} else {
					//everything passes; use the inputed value...
					this.uniqueTaskId = uniqueTaskId;
				}
			} catch (NumberFormatException exception) {
				throw new NumberFormatException();
			}
		
		}
		
		//Verify name is in approved range
		if (name.length() < 0 || name.length() > 20) {
			throw new IllegalArgumentException("Cant instantiate task with values outside of expected range");
		} else {
			this.name = name;
		}
		
		//Verify description is in approved range
		if(description.length() < 0 || description.length() > 50) {
			throw new IllegalArgumentException("Cant instantiate task with values outside of expected range");
		} else {
			this.description = description;
		}
	}
	
	
	
	//Getters
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	
	
	
	//Setters
	public void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if (name.length() < 0 || name.length() > 20) {
			throw new IllegalArgumentException("Value outside of expected range");
		}
		
		this.name = name; //set name after verification
	}
	
	public void setDescription(String description) throws IllegalArgumentException {
		if (description == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if (description.length() < 0 || description.length() > 50) {
			throw new IllegalArgumentException("Value outside of expected range");
		}
		
		this.description = description; //set description after verification
	}
	
	@Override
	public String toString() {
		return this.uniqueTaskId + " [|] " + name + " - " + description;
	}
	
	
}


