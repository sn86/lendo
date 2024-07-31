Application has the following endpoints

localhost:8080/authenticate
{
"username": "lendo",
"password": "password"
}
On using the bearer token following endpoints would work
localhost:8080/users
localhost:8080/users/posts
localhost:9000/users/comments?postIds=145159,145166