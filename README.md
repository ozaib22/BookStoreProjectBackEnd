Coverage: 74%% completed system
# # BookStoreProjectBackEnd - Presentation Link:

This project required me to create an application that will use a CRUD Functionalty that will allow the user to manage a BookStore.

- Project Management Tools - Jira Kanban Board and Github.
- Databases - mySQL and H2 for testing.
- Backend Application - SpringBoot JAVA
- Front End - HTML, CSS and JAVASCRIPT
- Testing - JUnit(Backend) PostMan(FrontEnd) H2(Database Intergration)


```
- The user will be able to create, update, delete, view all books in the system.
```

A JAVA backend application will react with a MySQL Database, HTML, CSS and JAVASCRIPT to create a fully functioning application that will do the following

```
- CREATE books
- VIEW all books
- UPDATE books
- DELETE books
```

## Application Planning Stages.

Project Management tool Jira was used to plan this project.
Epics were created to outline what tasks were needed for completion this was based on project specifications outlined by QA Trainers and was completed in a one week sprint.

```
![image](https://user-images.githubusercontent.com/98025347/157768039-79c91321-292c-4063-924c-ab4599b8eea8.png)
```

### Prerequisites and Installation

The following programs are needed to be installed to allow further development and testing.

To run this project it is recommended that you install the following programs to see full functionality of codes and relative databases.

```
- IDE ECLIPSE JAVA - instructions on how to complete installation - https://www.eclipse.org/downloads/packages/installer
- MAVEN - instructions on how to complete installation - https://o7planning.org/10101/install-maven-for-eclipse
- MySQL - instructions on how to complete installation - https://www.mysqltutorial.org/install-mysql/
- jUnit Test - instructions on how to complete installation - https://www.guru99.com/download-installation-junit.html
```

## Running the tests

To run tests on this application:

```
1. Naviagte to src/test/java 
2. Right click > Coverage as Junit Test
```

### Unit Tests 

The following tests have been created to test the item class, and will test if the coding has been implemented correctly to create an item name, value, delete item and read me functionalities.

```
public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "TV", 123.22);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "iWatch", 188.88));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "iWatch", 188.88), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(1L, "iWatch", 188.88), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "iWatch", 288.88);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
```


## Deployment

This application can be packaged in bytes and into .javac files for full running.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management.

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

Omar Zaib Mahmood

## License

This project is licensed under QA Training Academy - all works and codes are owned by QA Academy.

## Acknowledgments

The author would like to acknowledge the QA Training team for all its efforts and helps, aswell as the team members within the cohort who leading up to the project were helpful and inspiring. Moreover the author would like to thank family and friends for being supportive throughout this course, and god almighty.
