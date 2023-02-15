# Supplementary Specification (FURPS+)

## Functionality

All those who wish to use the application must be authenticated with a password holding seven alphanumeric characters,
including three capital letters and two digits.

Only the specialist doctor is allowed to access all client data.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

The interface will be easy to understand and useful.

All the images should be recorded in SVG format.

The user interface must be simple, intuitive and consistent.


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

Ensured data persistence between two runs of the application.


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

Any interface between a user and the system shall have a maximum response time of 3 seconds. The system should start up in less than 10 seconds.

The system should not fail more than 5 days in one year. Whenever the system fails, there should be no data loss.


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

Implementation of unit tests for almost all methods.


## +


### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  
The application must be developed in Java language using the IntelliJ IDE or Netbeans.

The application graphical interface is to be developed in JavaFX 11.

Use Javadoc to generate useful documentation for Java code.

The development team must implement unit tests for all methods except methods that implement
Input/Output operations.

The unit tests should be implemented using the JUnit 4 framework.

The JaCoCo plugin should be used to generate the coverage report.

All the images/figures produced during the software development process should be recorded in SVG format. 


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

The application must support the English language only.

The application should use object serialization to ensure data persistence between two runs of the
application.


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

An exeternal API is used to identify each sample with a barcode that is automatically generated.


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

The application will be deployed to a machine with 8GB of RAM.