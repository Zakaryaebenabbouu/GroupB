/**
 * 
 */
package org.mql.platform.business.internship;

import java.util.List;
import java.util.Optional;

import org.mql.platform.models.EnterpriseContact;
import org.mql.platform.models.EnterpriseSite;
import org.mql.platform.models.Internship;

/**
 * 
 * The Services of "Internship, EnterpriseService, EnterpriseContact" CRUD'S operations.
 * 
 * @author Yassir SALIH
 *
 */
public interface InternshipFacade {

	/***
	 * 
	 * 
	 * @param internship
	 * @return
	 */

	boolean addOrUpdateInternship(Internship internship);

	Optional<Internship> findInternshipById(Integer id);

	List<Internship> findAllInternships();

	Internship findInternshipByStudent(String cne);

	List<Internship> findInternshipByEnterprise(Integer id);

	boolean  removeInternship(Integer id);

	/***
	 * 
	 * 
	 * @param enterpriseContact
	 * @return
	 */

	boolean addOrUpdateEnterpriseContact(EnterpriseContact enterpriseContact);

	Optional<EnterpriseContact> findEnterpriseContactById(Integer id);

	List<EnterpriseContact> findAllEnterpriseContacts();

	boolean removeEnterprisecontact(Integer id);

	/***
	 * 
	 * 
	 * @param enterpriseSite
	 * @return
	 */

	boolean addOrUpdateEnterpriseSite(EnterpriseSite enterpriseSite);

	Optional<EnterpriseSite> findEnterpriseSiteById(Integer id);

	List<EnterpriseSite> findAllEnterpriseSites();

	boolean removeEnterpriseSite(Integer id);

}
