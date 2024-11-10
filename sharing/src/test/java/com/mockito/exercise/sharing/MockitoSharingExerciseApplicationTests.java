package com.mockito.exercise.sharing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MockitoSharingExerciseApplicationTests {

	@Test
	public void testAddAbbyToList() {
		// Create a mock list
		List<String> mockList = mock(List.class);

		// Add "Abby" to the mock list
		mockList.add("Abby");

		// Verify that "Abby" was added to the list
		verify(mockList).add("Abby");
	}




}
