package org.mql.platform.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author anouarma
 * @author chermehdi
 * @author Yassir SALIH : About the Address class we don't need it here , it's mentioned into EnterpriseSite
 */
@Entity
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String email;

	private int phoneNumber;

	private String website;

	@OneToMany(mappedBy = "enterprise")
	private List<Internship> internships = new ArrayList<>();

//	@OneToMany 
//	private List<Address> address = new ArrayList<>();

	@OneToMany(mappedBy ="enterprise")
	private Set<EnterpriseSite> enterpriseSites;
	
	@OneToMany(mappedBy="enterprise")
	private List<InternshipTest> tests  = new ArrayList<>();

	public Enterprise() {
		enterpriseSites = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Internship> getInternships() {
		return internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Set<EnterpriseSite> getEnterpriseSites() {
		return enterpriseSites;
	}

	public void setEnterpriseSites(Set<EnterpriseSite> enterpriseSites) {
		this.enterpriseSites = enterpriseSites;
	}

	public List<InternshipTest> getTests() {
		return tests;
	}

	public void setTests(List<InternshipTest> tests) {
		this.tests = tests;
	}

}
