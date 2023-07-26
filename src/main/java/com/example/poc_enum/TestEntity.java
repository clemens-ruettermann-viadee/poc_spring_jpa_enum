package com.example.poc_enum;

//import javax.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "test_tbl")
public class TestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "test_enum", length = 10)
	@Enumerated(EnumType.STRING)
	private TestEnum testEnum;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public TestEnum getTestEnum() {
		return testEnum;
	}

	public void setTestEnum(TestEnum testEnum) {
		this.testEnum = testEnum;
	}
}
