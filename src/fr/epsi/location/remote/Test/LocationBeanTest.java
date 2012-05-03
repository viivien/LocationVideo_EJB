package fr.epsi.location.remote.Test;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.unitils.*;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;

@JpaEntityManagerFactory(persistenceUnit = "test", configFile = "META-INF/persistence-test.xml")
@Transactional(TransactionMode.COMMIT)
@DataSet
public class LocationBeanTest extends UnitilsJUnit4 {

	@PersistenceContext
	EntityManager		entityManager;

	PersonRepository	personRepository	= new PersonRepositoryImpl();

	@Before
	public void init() {
		JpaUnitils.injectJpaResourcesInto(personRepository);
	}

	@Test
public void testSearchByLastName() {
List result = personRepository.findByLastName("Doe")); 
ReflectionAssert.assertPropertyLenEquals("firstName", Arrays.asList("John", "Jane"), result); 
}
}