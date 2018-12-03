/**
 * 
 */
package org.mql.platform.business.internship.impl;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

import org.mql.platform.business.internship.InternshipFacade;
import org.mql.platform.dao.EnterpriseContactRepository;
import org.mql.platform.dao.EnterpriseSiteRepository;
import org.mql.platform.dao.InternshipRepository;
import org.mql.platform.models.EnterpriseContact;
import org.mql.platform.models.EnterpriseSite;
import org.mql.platform.models.Internship;
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

	@Autowired
	public DefaultInternshipFacade(InternshipRepository internshipRepository,
			EnterpriseSiteRepository enterpriseSiteRepository,
			EnterpriseContactRepository enterpriseContactRepository) {
		super();
		this.internshipRepository = internshipRepository;
		this.enterpriseSiteRepository = enterpriseSiteRepository;
		this.enterpriseContactRepository = enterpriseContactRepository;
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

		List<Internship> internship = new Vector<>();
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
		List<EnterpriseContact> enterpriseContact = new Vector<>();
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
		List<EnterpriseSite> enterpriseSite = new Vector<>();
		if (enterpriseSite.get(id) != null) {
			enterpriseSiteRepository.deleteById(id);
			return true;
		} else
			throw new RuntimeException("EnterpriseSite not found");

	}

}
