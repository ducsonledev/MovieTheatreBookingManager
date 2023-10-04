## About The Project

### MovieTheatreBookingManager

MovieTheatreBookingManager serves as a tool for properly managing reservations for a theater to control the movies presented in screenings that are provided for the consumers and to purchase tickets that reserve seats in a screening.

### Work in Progress
- [ ] integration tests
- [ ] frontend with typescript
- [ ] deployment with terraform and AWS ECS

### Repository Structure

We present the repository structure as well as the functionality of the different major components in the following.

![grafik](https://github.com/ducsonledev/MovieTheatreBookingManager/assets/72577766/0f1334e7-b4bb-45a5-b599-9196015eb817)

### File Overview

```
├── HELP.md
├── README.md
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── movies
│   │   │           └── MovieTheatreBookingManager
│   │   │               ├── MovieBookingTheatreManagerApplication.java
│   │   │               ├── auth
│   │   │               │   └── AuthenticationService.java
│   │   │               ├── config
│   │   │               │   ├── ApplicationConfig.java
│   │   │               │   ├── JwtAuthenticationFilter.java
│   │   │               │   ├── JwtService.java
│   │   │               │   └── SecurityConfiguration.java
│   │   │               ├── controller
│   │   │               │   ├── MovieController.java
│   │   │               │   ├── ScreeningController.java
│   │   │               │   ├── SeatsController.java
│   │   │               │   └── UserAuthController.java
│   │   │               ├── dao
│   │   │               │   ├── MovieDao.java
│   │   │               │   ├── UserDao.java
│   │   │               │   └── UserDaoImpl.java
│   │   │               ├── domain
│   │   │               │   └── MovieScreening.java
│   │   │               ├── dto
│   │   │               │   ├── AuthenticationRequest.java
│   │   │               │   ├── AuthenticationResponse.java
│   │   │               │   ├── MovieDetails.java
│   │   │               │   ├── RegisterRequest.java
│   │   │               │   ├── UserRegistrationRequest.java
│   │   │               │   └── UserUpdateRequest.java
│   │   │               ├── entities
│   │   │               │   ├── Movie.java
│   │   │               │   ├── Role.java
│   │   │               │   ├── Screen.java
│   │   │               │   ├── Screening.java
│   │   │               │   ├── Seat.java
│   │   │               │   ├── Theatre.java
│   │   │               │   ├── Ticket.java
│   │   │               │   └── User.java
│   │   │               ├── exception
│   │   │               │   ├── DuplicateResourceException.java
│   │   │               │   ├── RequestValidationException.java
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               ├── repositories
│   │   │               │   ├── MovieRepository.java
│   │   │               │   ├── ScreenRepository.java
│   │   │               │   ├── ScreeningRepository.java
│   │   │               │   ├── TheatreRepository.java
│   │   │               │   ├── TicketRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               ├── runner
│   │   │               │   └── DataLoader.java
│   │   │               └── services
│   │   │                   ├── ScreeningService.java
│   │   │                   ├── ScreeningServiceImpl.java
│   │   │                   └── UserService.java
│   │   └── resources
│   │       ├── application.yml
│   │       ├── data.sql
│   │       ├── db
│   │       │   └── migration
│   │       │       ├── V1__Initial_Setup.sql
│   │       │       ├── V2__Create_Seats_Table.sql
│   │       │       ├── V3__Add_Column_Role_To_USERS.sql
│   │       │       ├── V4__Create_Enum_Type.sql
│   │       │       └── V5__Cast_Roles.sql
│   │       ├── links.csv
│   │       ├── movies.csv
│   │       ├── movies.medium.csv
│   │       ├── movies.orig.csv
│   │       ├── movies.small.csv
│   │       ├── ratings.csv
│   │       ├── schema.sql
│   │       ├── static
│   │       ├── tags.csv
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── movies
│                   └── MovieTheatreBookingManager
│                       ├── AbstractTestcontainers.java
│                       ├── MovieTheatreBookingManagerApplicationTests.java
│                       ├── TestcontainersTest.java
│                       ├── repositories
│                       │   ├── MovieRepositoryTest.java
│                       │   ├── ScreenRepositoryTest.java
│                       │   ├── ScreeningRepositoryTest.java
│                       │   └── TheatreRepositoryTest.java
│                       └── services
│                           └── UserServiceTest.java
└── target
    ├── classes
    │   ├── application.yml
    │   ├── com
    │   │   └── movies
    │   │       └── MovieTheatreBookingManager
    │   │           ├── MovieBookingTheatreManagerApplication.class
    │   │           ├── auth
    │   │           │   └── AuthenticationService.class
    │   │           ├── config
    │   │           │   ├── ApplicationConfig.class
    │   │           │   ├── JwtAuthenticationFilter.class
    │   │           │   ├── JwtService.class
    │   │           │   └── SecurityConfiguration.class
    │   │           ├── controller
    │   │           │   ├── MovieController.class
    │   │           │   ├── ScreeningController.class
    │   │           │   ├── SeatsController.class
    │   │           │   └── UserAuthController.class
    │   │           ├── dao
    │   │           │   ├── MovieDao.class
    │   │           │   ├── UserDao.class
    │   │           │   └── UserDaoImpl.class
    │   │           ├── domain
    │   │           │   └── MovieScreening.class
    │   │           ├── dto
    │   │           │   ├── AuthenticationRequest$AuthenticationRequestBuilder.class
    │   │           │   ├── AuthenticationRequest.class
    │   │           │   ├── AuthenticationResponse$AuthenticationResponseBuilder.class
    │   │           │   ├── AuthenticationResponse.class
    │   │           │   ├── MovieDetails.class
    │   │           │   ├── RegisterRequest$RegisterRequestBuilder.class
    │   │           │   ├── RegisterRequest.class
    │   │           │   ├── UserRegistrationRequest.class
    │   │           │   └── UserUpdateRequest.class
    │   │           ├── entities
    │   │           │   ├── Movie.class
    │   │           │   ├── Role.class
    │   │           │   ├── Screen.class
    │   │           │   ├── Screening.class
    │   │           │   ├── Seat.class
    │   │           │   ├── Theatre.class
    │   │           │   ├── Ticket.class
    │   │           │   ├── User$UserBuilder.class
    │   │           │   └── User.class
    │   │           ├── exception
    │   │           │   ├── DuplicateResourceException.class
    │   │           │   ├── RequestValidationException.class
    │   │           │   └── ResourceNotFoundException.class
    │   │           ├── repositories
    │   │           │   ├── MovieRepository.class
    │   │           │   ├── ScreenRepository.class
    │   │           │   ├── ScreeningRepository.class
    │   │           │   ├── TheatreRepository.class
    │   │           │   ├── TicketRepository.class
    │   │           │   └── UserRepository.class
    │   │           ├── runner
    │   │           │   ├── DataLoader$ProcessMovie.class
    │   │           │   └── DataLoader.class
    │   │           └── services
    │   │               ├── ScreeningService.class
    │   │               ├── ScreeningServiceImpl.class
    │   │               └── UserService.class
    │   ├── data.sql
    │   ├── db
    │   │   └── migration
    │   │       ├── V1__Initial_Setup.sql
    │   │       ├── V2__Create_Seats_Table.sql
    │   │       ├── V3__Add_Column_Role_To_USERS.sql
    │   │       ├── V4__Create_Enum_Type.sql
    │   │       └── V5__Cast_Roles.sql
    │   ├── links.csv
    │   ├── movies.csv
    │   ├── movies.medium.csv
    │   ├── movies.orig.csv
    │   ├── movies.small.csv
    │   ├── ratings.csv
    │   ├── schema.sql
    │   └── tags.csv
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── movies
                └── MovieTheatreBookingManager
                    ├── AbstractTestcontainers.class
                    ├── MovieTheatreBookingManagerApplicationTests.class
                    ├── TestcontainersTest.class
                    ├── repositories
                    │   ├── MovieRepositoryTest.class
                    │   ├── ScreenRepositoryTest.class
                    │   ├── ScreeningRepositoryTest.class
                    │   └── TheatreRepositoryTest.class
                    └── services
                        └── UserServiceTest.class
```
## Data

### Datasets

MovieLens dataset (small): http://files.grouplens.org/datasets/movielens/

## Getting Started

These instructions will allow you to get the project up and running on your local machine for development and testing purposes.

### Prerequisites

1. Internet connection, to extract poster images from www.imdb.com
2. Copy dependencies from `pom.xml`
