/**
 * 
 */
package org.mql.platform.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Yassir SALIH
 *
 */
@Entity
public class InternshipTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String testName;

	@OneToMany
	private Set<Document> examples;

	@ManyToMany
	private List<Student> students;

	@ManyToOne
	private Enterprise enterprise;

	public InternshipTest() {
		examples = new HashSet<>();
		students = new Vector<>();
	}

	public InternshipTest(Integer id, String testName, Set<Document> examples, List<Student> students,
			Enterprise enterprise) {
		super();
		this.id = id;
		this.testName = testName;
		this.examples = examples;
		this.students = students;
		this.enterprise = enterprise;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Set<Document> getExamples() {
		return examples;
	}

	public void setExamples(Set<Document> examples) {
		this.examples = examples;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Override
	public String toString() {
		return "InternshipTest [id=" + id +
				", testName=" + testName +
				", examples=" + examples +
				", students="+ students +
				", enterprise=" + enterprise + "]";
	}

}
