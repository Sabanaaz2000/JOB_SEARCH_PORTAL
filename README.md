# <h1 align="center"> Job Search Portal </h1>
<p align="center">
<a href="Java url">
<img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
<img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
<img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />

</p>

 

---

 

<p align="left">

 

## Overview

 

The Job Search Portal is a simple Spring Boot application that allows you to add, get, update and delete Jobs with endpoint has been accessed. It also provides an additional feature to add all the data in database.

 

## Technologies Used

 

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven
- **Database:** H2 Database

 

## Data Flow

 

The Job Search Portal application follows a structured data flow pattern to handle requests and manage data efficiently:

 

### Controller

 

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for various operations, including adding jobs, retrieving jobs, and updating jobs. Each endpoint maps to a specific service method to ensure proper request handling and response generation.

 

```java
@RestController
public class JobController {

    @Autowired
    JobService myJob;

    @PostMapping("jobs")
    public String addAllJobs(@RequestBody List<Job> newJob){
        return myJob.addAllMyJobs(newJob);
    }
    .
    .
    .
}
```

 

### Service

 

The Service layer encapsulates the core business logic and data processing. It interacts with the repo layer to retrieve and store data. In this application, it handles operations like adding jobs, retrieving jobs, and updating jobs for company. The Service layer validates input data and performs necessary operations before returning results to the Controller.

 

```java
@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

    public String addAllMyJobs(List<Job> newJob) {
        jobRepo.saveAll(newJob);
        return newJob.size()+" jobs added successfully";
    }
 

    // Service methods for various operations
    // ...
}
```

 

### Model

 

The model layer manages data access to in-memory storage. It maintains a list of `JobController` objects to store uploaded jobs. Also I have a Entity Type for job type. While this in-memory storage is suitable for a simple application, in a production environment, a database should be used for data persistence.

 

```java
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    private Long jobId;

    private  String jobTitle;
    private String jobDescription;

    // Repository methods for managing visitor data
    // ...
}
```

 

## Database Design

 

The Job Search Portal application utilizes a simple in-memory data structure to store all the jobs. In a production environment, it is advisable to replace this in-memory storage with a relational or NoSQL database for better data persistence and scalability.

 

### In-Memory Data Structure

 

The primary data structure used in this application is a `H2 Database`. This structure allows for easy manipulation of jobs data but is not suitable for long-term data storage.

 

```java
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    private Long jobId;

    private  String jobTitle;
    private String jobDescription;
```

 

## Data Structures Used


### List
Basically I used List for giving the list of my jobs to add in database also I for getting I used List.



 

### UrlHitCounter Class

 

The `Job` class defines the structure for all the datamember. It includes ten fields: jobId, jobTitle, jobDescription, companyLocation, salary, companyEmail, companyName, employerName, jobType, appliedDate.

 

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    private Long jobId;

    private  String jobTitle;
    private String jobDescription;
    private  String companyLocation;

    @Min(value = 20000, message = "Salary must be at least 20000")
    private Double salary;

    @Email(message = "Email should be in email format.")
    private String companyEmail;
    private String companyName;
    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedDate;
```

 

 

## Endpoints

 
### Add All Jobs

- **HTTP Method**: POST
- **Endpoint**: `/jobs`
- **Description**: Add a list of jobs to the system.

### Get All Jobs

- **HTTP Method**: GET
- **Endpoint**: `/jobs`
- **Description**: Retrieve a list of all jobs in the system.

### Get Job by ID

- **HTTP Method**: GET
- **Endpoint**: `/job/id/{id}`
- **Description**: Retrieve a job by its unique ID.

### Find Jobs by Type

- **HTTP Method**: GET
- **Endpoint**: `/jobs/type/{types}`
- **Description**: Find jobs by their type.

### Find Jobs by Company Name

- **HTTP Method**: GET
- **Endpoint**: `/jobs/company/name/{companyName}`
- **Description**: Find jobs by the name of the company offering them.

### Find Jobs by Company Name and Job Type

- **HTTP Method**: GET
- **Endpoint**: `/jobs/company/name/{companyName}/job/type/{types}`
- **Description**: Find jobs by both company name and job type.

### Find Jobs by Job Type and Greater Than Amount

- **HTTP Method**: GET
- **Endpoint**: `/jobs/type/{types}/greater/{amount}`
- **Description**: Find jobs of a specific type with a salary greater than a specified amount.

### Get Jobs Before a Date

- **HTTP Method**: GET
- **Endpoint**: `/jobs/date/before`
- **Description**: Get a list of jobs posted before a given date.

### Get Jobs After a Date

- **HTTP Method**: GET
- **Endpoint**: `/jobs/date/after`
- **Description**: Get a list of jobs posted after a given date.

### Update Job by ID

- **HTTP Method**: PUT
- **Endpoint**: `/job/id/{id}`
- **Description**: Update a job's details by its unique ID.

### Update Salary by Type

- **HTTP Method**: PUT
- **Endpoint**: `/job/id/salary/hike`
- **Description**: Update the salary of a job by its ID with a specified hike.

### Remove Job by ID

- **HTTP Method**: DELETE
- **Endpoint**: `/job/id/{id}`
- **Description**: Remove a job by its unique ID.

### Remove All Jobs

- **HTTP Method**: DELETE
- **Endpoint**: `/jobs`
- **Description**: Remove all jobs from the system.

### Remove Jobs Before a Date

- **HTTP Method**: DELETE
- **Endpoint**: `/jobs/before/date`
- **Description**: Remove all jobs posted before a given date from the system.


 

## Usage

 

1. Use a tool like [Swagger IO](https://swagger.io/) to make HTTP requests to the provided endpoints.


 

## Project Structure

 

The project follows a standard Spring Boot application structure with components organized into layers:

 

- **Controller:** Handles incoming HTTP requests and defines API endpoints.
- **Service:** Implements business logic and interacts with the repository.
- **Repository:** Manages data access and storage.
- **Entity:** Defines data models.
- **BeanManager:** Contains Spring bean configurations.

 

## Data Storage

 

All the data will store in H2 Database.

 

## Contributing

 

Contributions to this project are welcome! If you have any suggestions, find issues, or want to enhance the functionality, please feel free to open an issue or submit a pull request.

 

 

<!-- Acknowledgments -->
## Acknowledgments
Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

 

<!-- Contact -->
## Contact
For questions or feedback, please contact [Rebel Sk](mailto:iamrebelsk@gmail.com).
