package com.example.poc_enum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

	@Query("SELECT t from TestEntity AS t WHERE t.testEnum = :#{#dto.testEnum} OR (t.testEnum IS NULL AND :#{#dto.testEnum} IS NULL)")
	List<TestEntity> findAllFilteringEnumValue(@Param("dto") Dto dto);

}
