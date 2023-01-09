
# Demo Graphql Spring Boot

In this repo you going to find some crud operation using graphql with spring boot on student
entity that have id, name, and email fields.

When you run the application you already have 3 students added to the H2 database, you dont
have anything to config just run && play ! 

## Graphql schema

``` graphql
type Query {
    getStudents: [Student]
    studentById(id: ID): Student
    addStudent(student: StudentInput): Student
    updateStudentById(id: ID, student: StudentInput): Student
    deleteStudentById(id: ID) : String

}

type Student {
    id: ID
    name: String
    email: String
}

input StudentInput {
    name: String!
    email: String!
}

```

### Run Queries
You can go to ``http://localhost:8080/graphiql``to run qeuries or you can use other clients.

#### Get all students query
```graphql
{
  getStudents {
    name
    email
  }
}
```

#### Get student by id query
```graphql
{
  studentById(id: "1") {
    name
    email
  }
}
```

#### Add student and return the ID or whatever you want from student such as name and email
```graphql
{
  addStudent(student: {name: "Mohammed", email: "mohammed@gmail.com"}) {
    id
  }
}
```

#### Update student by id

```graphql
{
  updateStudentById(id: "2", student: {name: "khalil", email: "khalil@gmail.com"}) {
    name
    email
  }
}
```

#### Delete student by id

```graphql
{
 deleteStudentById(id: "2")
}
```


