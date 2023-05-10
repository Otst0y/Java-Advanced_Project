package project;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import project.dao.BucketRepository;
import project.dao.PeriodicalRepository;
import project.dao.UserRepository;
import project.domain.Bucket;
import project.domain.Periodical;
import project.domain.User;
import project.domain.UserRole;
import project.service.BucketService;
import project.service.PeriodicalsService;
import project.service.UserService;


@SpringBootTest
class ComicsStashApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private PeriodicalsService periodicalsService;

	@Autowired
	private BucketService bucketService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PeriodicalRepository periodicalRepository;

	@Autowired
	private BucketRepository bucketRepository;

	@Test
	void contextLoads() {
		userRepository.deleteAll();
		List<User> users = userRepository.findAll();
		userRepository.deleteAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));

	}

	@Test
	public void testFindByEmail() {
		userRepository.deleteAll();
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}

	@Test
	public void testSavePeriodical() {
		periodicalRepository.deleteAll();
		List<Periodical> periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(0));

		Periodical periodical = new Periodical();
		periodical.setName("1");
		periodical.setDescription("1");
		periodical.setEncodedImage("1");
		periodical.setPrice(1d);

		periodicalsService.save(periodical);

		periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(1));

		Periodical periodicalFromDb = periodicals.get(0);
		assertTrue(periodicalFromDb.getName().equals(periodical.getName()));
		assertTrue(periodicalFromDb.getDescription().equals(periodical.getDescription()));
		assertTrue(periodicalFromDb.getEncodedImage().equals(periodical.getEncodedImage()));
		assertTrue(periodicalFromDb.getPrice().equals(periodical.getPrice()));
	}

	@Test
	public void testFindById() {
		periodicalRepository.deleteAll();
		List<Periodical> periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(0));

		Periodical periodical = new Periodical();
		periodical.setName("1");
		periodical.setDescription("1");
		periodical.setEncodedImage("1");
		periodical.setPrice(1d);

		periodicalRepository.save(periodical);

		periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(1));

		Periodical periodicalFromDb = periodicalsService.findById(periodicals.get(0).getId());

		assertTrue(periodicalFromDb.getName().equals(periodical.getName()));
		assertTrue(periodicalFromDb.getDescription().equals(periodical.getDescription()));
		assertTrue(periodicalFromDb.getEncodedImage().equals(periodical.getEncodedImage()));
		assertTrue(periodicalFromDb.getPrice().equals(periodical.getPrice()));
	}

	@Test
	public void testGetAllPeriodicals() {
		periodicalRepository.deleteAll();
		List<Periodical> periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(0));

		Periodical periodical = new Periodical();
		periodical.setName("1");
		periodical.setDescription("1");
		periodical.setEncodedImage("1");
		periodical.setPrice(1d);

		Periodical periodical2 = new Periodical();
		periodical2.setName("12");
		periodical2.setDescription("12");
		periodical2.setEncodedImage("12");
		periodical2.setPrice(12d);

		periodicalRepository.saveAll(Arrays.asList(periodical, periodical2));

		periodicals = periodicalRepository.findAll();
		assertThat(periodicals, hasSize(2));

		List<Periodical> periodicalsFromDb = periodicalsService.getAllPeriodicals();

		assertTrue(periodicalsFromDb.get(0).getName().equals(periodical.getName()));
		assertTrue(periodicalsFromDb.get(0).getDescription().equals(periodical.getDescription()));
		assertTrue(periodicalsFromDb.get(0).getEncodedImage().equals(periodical.getEncodedImage()));
		assertTrue(periodicalsFromDb.get(0).getPrice().equals(periodical.getPrice()));

		assertTrue(periodicalsFromDb.get(1).getName().equals(periodical2.getName()));
		assertTrue(periodicalsFromDb.get(1).getDescription().equals(periodical2.getDescription()));
		assertTrue(periodicalsFromDb.get(1).getEncodedImage().equals(periodical2.getEncodedImage()));
		assertTrue(periodicalsFromDb.get(1).getPrice().equals(periodical2.getPrice()));
	}
}
