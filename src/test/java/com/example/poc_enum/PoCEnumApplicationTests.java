package com.example.poc_enum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PoCEnumApplicationTests {

	@Autowired
	private TestRepository testRepository;

	@BeforeEach
	void setUp() {
		TestEntity entity1 = new TestEntity();
		TestEntity entity2 = new TestEntity();
		entity2.setTestEnum(TestEnum.VALUE_2);
	 	testRepository.save(entity1);
		testRepository.save(entity2);
	}

	@Test
	void contextLoads() {
		Dto dto = new Dto();
		dto.setTestEnum(null);
		List<TestEntity> allFilteringEnumValue = testRepository.findAllFilteringEnumValue(dto);

		assertEquals(1, allFilteringEnumValue.size());
		assertTrue(allFilteringEnumValue.stream().allMatch(testEntity -> testEntity.getTestEnum() == null));


		dto.setTestEnum(TestEnum.VALUE_1);
		assertTrue(testRepository.findAllFilteringEnumValue(dto).isEmpty());
	}

}
