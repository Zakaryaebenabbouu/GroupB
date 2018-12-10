/**
 * 
 */
package org.mql.platform.business.internship.impl;

import java.util.List;
import java.util.Optional;

import org.mql.platform.business.internship.InternshipFacade;
import org.mql.platform.dao.EnterpriseContactRepository;
import org.mql.platform.dao.EnterpriseSiteRepository;
import org.mql.platform.dao.InternshipRepository;
import org.mql.platform.dao.InternshipTestRepository;
import org.mql.platform.models.EnterpriseContact;
import org.mql.platform.models.EnterpriseSite;
import org.mql.platform.models.Internship;
import org.mql.platform.models.InternshipTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yassir SALIH
 *
 */
@Service
public class DefaultInternshipFacade implements InternshipFacade {

	private InternshipRepository internshipRepository;
	private EnterpriseSiteRepository enterpriseSiteRepository;
	private EnterpriseContactRepository enterpriseContactRepository;
	private InternshipTestRepository internshipTestRepository;

	@Autowired
	public DefaultInternshipFacade(InternshipRepository internshipRepository,
			EnterpriseSiteRepository enterpriseSiteRepository,
			EnterpriseContactRepository enterpriseContactRepository,
			InternshipTestRepository internshipTestRepository) {
		super();
		this.internshipRepository = internshipRepository;
		this.enterpriseSiteRepository = enterpriseSiteRepository;
		this.enterpriseContactRepository = enterpriseContactRepository;
		this.internshipRepository = internshipRepository;
	}

	@Transactional
	public boolean addOrUpdateInternship(Internship internship) {
		try {
			return internshipRepository.save(internship) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Optional<Internship> findInternshipById(Integer id) {
		try {
			Optional<Internship> i = internshipRepository.findById(id);
			System.out.println("======>" + i);
			Optional.of(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(null);
	}

	public List<Internship> findAllInternships() {

		try {
			return internshipRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Internship findInternshipByStudent(String cne) {

		try {
			return internshipRepository.findByStudent(cne);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Internship> findInternshipByEnterprise(Integer id) {

		try {
			internshipRepository.findByEnterprise(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Transactional
	public boolean removeInternship(Integer id) {

		List<Internship> internship = findAllInternships();
		if (internship.get(id) != null) {
			internshipRepository.deleteById(id);
			return true;
		} else
			throw new RuntimeException("Internship not found !!");
	}

	@Transactional
	public boolean addOrUpdateEnterpriseContact(EnterpriseContact enterpriseContact) {
		try {
			return enterpriseContactRepository.save(enterpriseContact) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Optional<EnterpriseContact> findEnterpriseContactById(Integer id) {
		try {
			Optional<EnterpriseContact> enterpriseContact = enterpriseContactRepository.findById(id);
			System.out.println("=====>" + enterpriseContact);
			Optional.of(enterpriseContact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(null);

	}

	public List<EnterpriseContact> findAllEnterpriseContacts() {
		try {
			return enterpriseContactRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	public boolean removeEnterprisecontact(Integer id) {
		List<EnterpriseContact> enterpriseContact = findAllEnterpriseContacts();
		if (enterpriseContact.get(id) != null) {
			enterpriseContactRepository.deleteById(id);
			return true;
		} else
			throw new RuntimeException("EnterpriseContact not found !!");
	}

	@Transactional
	public boolean addOrUpdateEnterpriseSite(EnterpriseSite enterpriseSite) {
		try {
			return enterpriseSiteRepository.save(enterpriseSite) != null;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Optional<EnterpriseSite> findEnterpriseSiteById(Integer id) {
		try {
			Optional.of(enterpriseSiteRepository.findById(id));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(null);
	}

	public List<EnterpriseSite> findAllEnterpriseSites() {
		try {
			return enterpriseSiteRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	public boolean removeEnterpriseSite(Integer id) {
		List<EnterpriseSite> enterpriseSite = findAllEnterpriseSites();
		if (enterpriseSite.get(id) != null) {
			enterpriseSiteRepository.deleteById(id);
			return true;
		} else
			throw new RuntimeException("EnterpriseSite not found");

	}

	@Transactional
	public boolean addOrUpdateInternshipTest(InternshipTest internshipTest) {
		try {
			return internshipTestRepository.save(internshipTest) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Optional<InternshipTest> findInternshipTestById(Integer id) {
		try {
			Optional<InternshipTest> internshipTest = internshipTestRepository.findById(id);
			System.out.println("======>" + internshipTest);
			Optional.of(internshipTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(null);
	}

	public List<InternshipTest> findAllInternshipTests() {
		try {
			return internshipTestRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	public boolean removeInternshipTest(Integer id) {

		List<InternshipTest> internshipTest = findAllInternshipTests();
		if (internshipTest.get(id) != null) {
			internshipTestRepository.deleteById(id);
			return true;
		} else
			throw new RuntimeException("InternshipTest not found !!");

	}

}
