
# Hotel Booking System

Hotel Booking System is an application which lets you manage the room booking process.It has various Http endpoints to create, fetch, update and delete User, Hotels and Bookings from the system.




## API Reference

#### Get all Hotels

```http
  GET /stayease/api/v1/hotels
```

#### Create Hotel
```http
  POST /stayease/api/v1/hotels
```
Request Body
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | **Required**. name of hotel to create|
| `location`| `string` | **Required**.  location of hotel to create |
| `description`| `string` | **Required**.  description of hotel to create |
| `availableRooms`| `int` | **Required**.  No. of avaialble rooms in hotel|

#### Register a new User

```http
  POST /stayease/api/v1/users
```
Request Body
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `string` | **Required**. name of User |
| `lastName`      | `string` | **Required**. name of User |
| `email`      | `string` | **Required**. name of User |
| `password`      | `string` | **Required**. name of User |
| `Role`      | `string` | **Optional**. Role of User |


#### Public Postman collection to test API
https://www.postman.com/mission-saganist-78647024/workspace/harshit-goyal/request/19091992-83a58585-1e50-4168-a20a-27191084a672



## Deployment

To run this project run

```bash
  ./gradlew bootrun
```

