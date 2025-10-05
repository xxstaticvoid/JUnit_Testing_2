package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import mod4milestone.Task;

class TaskTest {

	
	@Test
	void testTaskClass1() {
		//Task 1
		var testTask = new Task("123", "Task Name", "Simple Task Description");
				
		assertEquals(testTask.getDescription(), "Simple Task Description");
		assertEquals(testTask.getName(), "Task Name");

				
		assertTrue(testTask.getName().length() <= 20);
		assertTrue(testTask.getDescription().length() <= 50);
		
				
	}
	
	
	@Test
	void testTaskClass2() {
		//Task 2
		Task testTask = new Task("67", "Task Name", "Simple Task Description");
		
		testTask.setName("New Task Name");
		testTask.setDescription("New Description");
		assertEquals(testTask.getDescription(), "New Description");
		assertEquals(testTask.getName(), "New Task Name");
	}
	
	
	@Test
	void testTaskClass3() {
		assertThrows(IllegalArgumentException.class, () -> new Task("100000000000", "Task Name", "Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("-5", "Name", "Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("-500", "Name", "Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("", "NAME", "DESC"));
		
		
		assertThrows(IllegalArgumentException.class, () -> new Task("123", "Test Task Name", null));
		assertThrows(IllegalArgumentException.class, () -> new Task(null, null, null));
		assertDoesNotThrow(() -> new Task("13", "NAME", "DESC"));
		
		var testTask = new Task("420", "First Name", "First Description");
		assertThrows(IllegalArgumentException.class, () -> testTask.setName(new String(new char[21])));
		assertThrows(IllegalArgumentException.class, () -> testTask.setDescription(new String(new char[51])));
		assertDoesNotThrow(() -> testTask.setName(new String(new char[20])));
		assertDoesNotThrow(() -> testTask.setDescription(new String(new char[50])));
	}
	
	@Test
	void testTaskClass4() {
		//IMPORTANT TESTS MUST PASSS !!!!
		assertThrows(NumberFormatException.class, () -> new Task("---5", "Name", "Description"));
		assertThrows(NumberFormatException.class, () -> new Task("asdasd", "Name", "Description"));	
		assertThrows(NumberFormatException.class, () -> new Task("5.0", "Name", "Description"));	
		assertThrows(NumberFormatException.class, () -> new Task("0.0.0.", "Name", "Description"));	
		assertThrows(NumberFormatException.class, () -> new Task("&^#$&%^*&#", "Name", "Description"));	
		
	}
	
	

}
