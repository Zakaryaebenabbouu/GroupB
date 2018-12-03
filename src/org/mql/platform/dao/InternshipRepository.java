package org.mql.platform.dao;

import java.util.List;
import org.mql.platform.models.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chermehdi
 */
public interface InternshipRepository extends JpaRepository<Internship, Integer> {

	@Query("select i from internship i where i.student.cne = ?1")
	Internship findByStudent(String cne);

	@Query("select i from internship i where i.entrprise.id = ?1 ")
	List<Internship> findByEnterprise(Integer id);

}
