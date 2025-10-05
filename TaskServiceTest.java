package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import mod4milestone.TaskService;

class TaskServiceTest {
	
	TaskService service;

	@BeforeEach
	void setUp() {
		service = new TaskService();
	}

	@Test
	void testTaskService1() {
		assertThrows(RuntimeException.class, () -> service.getTask(5L));
		assertThrows(RuntimeException.class, () -> service.getTask(-5L));
		
		service.addTask("NAME", "DESCRIPTION");
		
		assertEquals(service.getCurrentId(), 2L);
		
		assertEquals(service.getTask(1L).getName(), "NAME");
		assertEquals(service.getTask(1L).getDescription(), "DESCRIPTION");

		
		service.updateName(1L, "Joseph");
		service.updateDescription(1L, "Ebersole");
		
		assertEquals(service.getTask(1L).getName(), "Joseph");
		assertEquals(service.getTask(1L).getDescription(), "Ebersole");
	}
	
	
	@Test
	void testTaskService2() {
		assertDoesNotThrow(() -> service.addTask("Cooper", "DeJean")); //valid
		assertThrows(IllegalArgumentException.class, () -> service.addTask(null, "tu")); //one null add
		assertThrows(IllegalArgumentException.class, () -> service.addTask(null, null)); //full null add
		assertThrows(IllegalArgumentException.class, () -> service.addTask("Jordan", new String(new char[52])));
		assertThrows(IllegalArgumentException.class, () -> service.addTask(new String(new char[21]), "Davis"));
		
		assertThrows(IllegalArgumentException.class, () -> service.updateName(1L, null));
		assertThrows(IllegalArgumentException.class, () -> service.updateDescription(1L, null));
		
	}
	
	@Test
	void testTaskService3() {
		for(int i = 0; i < 25; i++) {
			service.addTask("TASK NAME", "TASK DESCRIPTION");
		}
		
		assertEquals(service.getCurrentId(), 26L);
		service.addTask("DIFFERENT NAME", "DIFFERENT DESCRIPTION");
		assertEquals(service.getTask(26L).getName(), "DIFFERENT NAME");
		assertEquals(service.getTask(11L).getDescription(), "TASK DESCRIPTION");
	}
}
