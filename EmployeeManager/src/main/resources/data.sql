insert into roles values(1,'USER');
insert into roles values(2,'ADMIN');

insert into users(user_id, user_name, user_password) values(1,'suresh','$2a$10$nVVbXhUHgRoURTVdkr1kw.SbNBp9R6GbADF/6AORYd/Exv3lwye6a');
insert into users(user_id, user_name, user_password) values(2,'ramesh','$2a$10$Gwh4H33UX3waS6tScXBww.06GHAh4EIuc0RbQGG0exUrwLzmO0kmG');

insert into users_roles values(1,1);
insert into users_roles values(1,2);
insert into users_roles values(2,1);

insert into employee(id,first_name,last_name,email) values(1,'Suresh','Reddy','suresh.mudireddy@gmail.com');
insert into employee(id,first_name,last_name,email) values(2,'Ramesh','Reddy','ramesh.mudireddy@gmail.com');
insert into employee(id,first_name,last_name,email) values(3,'kiran','Kumar','kiran.kumar@gmail.com');
insert into employee(id,first_name,last_name,email) values(4,'Rakesh','Reddy','rakesh.reddy@gmail.com');