# REST API for Online Cab Booking Application

We have create a REST API for online cab booking application which can be used by customers to login into their profile, update their information and 
book cabs, by a driver to login and update their details along with their cab details and accept a ride from the customer. All this is over looked by the 
admin who can also login and update their information as well as access the data in the application. 

### ER-Diagram
![ERDiagram](https://user-images.githubusercontent.com/54835356/201510759-1646e4d9-66f0-4372-994d-b7c399f6c615.jpg)

### Database Schema
![Database Schema](https://user-images.githubusercontent.com/54835356/201510762-ba22fda4-d738-433e-88b0-9de1190df9f2.jpg)

### This is a collaborative project, completed by a team of 5 backend developers at Masai School.

# Collaborators

- [Aman Sharma](https://github.com/Aman103767)
- [Rohit Kumar](https://github.com/RohitJsr)
- [Akash Kumar](https://github.com/akashkumar124)
- [Khaja Moinuddin](https://github.com/KhajaMoinuddin9836)
- [Anurag Shekhawat](https://github.com/Anurag-shekawat)

# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven

# Modules

- Login Module
- Cab Driver Module
- Customer Module
- Admin Module
- Trip Details Module

# Features

- Data Authentication and Validation for all the users (Admin, Customer and Cab Driver)

## Admin Features
- Admin can access all Trip Details along with specific trip details using a particular cab or a customer.


## Customer Features
- Customer can login in the application and update their information using their mobile number and password.
- Customer can book trips using pickup location and destination.
- Customer can access the bill after the trip is completed.


## Cab Driver features
- Cab Driver can login in the application and update their information using generated key at the time of login.
- Cab driver can add and update their cab details.
- Cab Driver can mark their availability according to the trips status.
- Cab Driver can end the trip and application generates a bill for the trip.

# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/sb201db;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8888/
```
```
http://localhost:8888/swagger-ui/
```
# API Reference

## Customer Requests

```http
  Customer Controller
```

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Create` | `http://localhost:8888/customer/create` | Create Customer |
| `PUT` | `Update` | `http://localhost:8888/customer/update` | Update Customer |
| `DELETE` | `Delete` | `http://localhost:8888/customer/delete` | Delete Customer |
| `POST` | `Book Trip` | `http://localhost:8888/customer/booktriping` | Book Trip |
| `DELETE` | `Cancel Trip` | `http://localhost:8888/customer/canceltrip` | Cancel Trip |
| `POST` | `Trip List` | `http://localhost:8888/customer/triplist` | Trip List |
| `POST` | `Generate Bill` | `http://localhost:8888/customer/generateBill` | Generate Bill |
| `GET`  |  `View All Customer` | `http://localhost:8888/customer/viewAll`| View All Customer|
| `GET`  |  `View Customer` | `http://localhost:8888/customer/viewAll`| View Customer|


## Cab Driver Requests

```http
  Cab Driver Controller 
```

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Create` | `http://localhost:8888/cabdriver/create` | Create Cab Driver |
| `PUT` | `Update` | `http://localhost:8888/cabdriver/update` | Update Cab Driver |
| `DELETE` | `Delete` | `http://localhost:8888/cabdriver/delete` | Delete Cab Driver |
| `POST` | `Book Trip` | `http://localhost:8888/cabdriver/tripcompleted` | Trip Completed |


## Admin Requests

```http
  Admin Controller
```

| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Create` | `http://localhost:8888/admin/create` | Create Admin |
| `PUT` | `Update` | `http://localhost:8888/admin/update` | Update Admin |
| `DELETE` | `Delete` | `http://localhost:8888/admin/delete` | Delete Admin |
| `POST` | `Get All Trip` | `http://localhost:8888/admin/getalltrips` | Show All Trip |
| `GET` | `Get Trip By Cab` | `http://localhost:8888/admin/getalltripsbycab/{cabId}` | Get All Trip By Cab ID |



