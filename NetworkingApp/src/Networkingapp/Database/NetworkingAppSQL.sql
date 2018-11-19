/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



DROP TABLE Profile;
DROP TABLE Login;
DROP TABLE Send_Message;
DROP TABLE Post_Category;
DROP TABLE Category;
DROP TABLE App_Comment;
DROP TABLE Advertisement;
DROP TABLE Supervise;
DROP TABLE Post;
DROP TABLE Supervisor;
DROP TABLE Message;
DROP TABLE App_User;

commit;

CREATE TABLE App_User(
user_ID VARCHAR(8) PRIMARY KEY,
user_password VARCHAR(20) NOT NULL);

CREATE TABLE Profile(
profile_ID VARCHAR(8) PRIMARY KEY,
profile_name VARCHAR(15) NOT NULL,
profile_age INTEGER,
profile_location VARCHAR(60),
profile_gender VARCHAR(10),
user_ID VARCHAR(8) UNIQUE,
FOREIGN KEY(user_ID) REFERENCES App_User ON DELETE CASCADE);

CREATE TABLE Login(
login_IPaddress VARCHAR(15),
login_time Timestamp,
user_ID VARCHAR(8),
PRIMARY KEY(login_IPaddress, login_time, user_ID),
FOREIGN KEY(user_ID) REFERENCES App_User ON DELETE CASCADE);

CREATE TABLE Message(
message_ID VARCHAR(8) PRIMARY KEY,
message_content VARCHAR(200) NOT NULL);

CREATE TABLE Send_Message(
message_ID VARCHAR(8),
send_message_writerID VARCHAR(8),
send_message_receiverID VARCHAR(8),
PRIMARY KEY (message_ID, send_message_writerID, send_message_receiverID),
FOREIGN KEY (message_ID) REFERENCES Message ON DELETE CASCADE,
FOREIGN KEY (send_message_writerID) REFERENCES App_User(user_ID) ON DELETE CASCADE,
FOREIGN KEY (send_message_receiverID) REFERENCES App_User(user_ID) ON DELETE CASCADE);

CREATE TABLE Post(
post_ID VARCHAR(8) PRIMARY KEY,
post_title VARCHAR(100) NOT NULL,
post_time TIMESTAMP NOT NULL,
post_content VARCHAR(500),
user_ID VARCHAR(8),
FOREIGN KEY (user_ID) REFERENCES App_User ON DELETE SET NULL);

CREATE TABLE Category(
category_Name VARCHAR(15) PRIMARY KEY,
category_description VARCHAR(100));

CREATE TABLE Post_Category(
post_ID VARCHAR(8),
category_Name VARCHAR(15),
PRIMARY KEY(post_ID, category_Name),
FOREIGN KEY(post_ID) REFERENCES Post ON DELETE CASCADE,
FOREIGN KEY(category_Name) REFERENCES Category ON DELETE CASCADE);

CREATE TABLE App_Comment(
user_ID VARCHAR(8),
post_ID VARCHAR(8),
comment_ID VARCHAR(8),
comment_Time TIMESTAMP NOT NULL,
comment_content VARCHAR(200),
PRIMARY KEY(user_ID, post_ID, comment_ID),
FOREIGN KEY(user_ID) REFERENCES App_User ON DELETE CASCADE,
FOREIGN KEY(post_ID) REFERENCES Post ON DELETE CASCADE);

CREATE TABLE Advertisement(
post_ID VARCHAR(8) PRIMARY KEY,
advertisement_pay REAL NOT NULL,
advertisement_brand VARCHAR(30) NOT NULL,
FOREIGN KEY(post_ID) REFERENCES Post ON DELETE CASCADE);

CREATE TABLE Supervisor(
supervisor_ID VARCHAR(8) PRIMARY KEY,
supervisor_name VARCHAR(15) NOT NULL);

CREATE TABLE Supervise(
supervisor_ID VARCHAR(8),
user_ID VARCHAR(8),
post_ID VARCHAR(8),
PRIMARY KEY(supervisor_ID, user_ID, post_ID),
FOREIGN KEY(supervisor_ID) REFERENCES Supervisor ON DELETE CASCADE,
FOREIGN KEY(user_ID) REFERENCES App_User ON DELETE CASCADE,
FOREIGN KEY(post_ID) REFERENCES Post ON DELETE CASCADE);

commit;


INSERT INTO App_User VALUES('10000001','abc123');
INSERT INTO App_User VALUES('10000002','asdhfaulrif');
INSERT INTO App_User VALUES('10000003','12jk4b12l4');
INSERT INTO App_User VALUES('10000004','jb1rg327irt');
INSERT INTO App_User VALUES('10000005','128912h1p8');
INSERT INTO App_User VALUES('10000006','^&RV@I&');
INSERT INTO App_User VALUES('10000007','abc123');
INSERT INTO App_User VALUES('10000008','abc123');
INSERT INTO App_User VALUES('10000009','heihei123456');
INSERT INTO App_User VALUES('10000010','abc123');
INSERT INTO PROFILE VALUES('20000001','Andy', 22, 'Vancouver', 'Male', '10000001');
INSERT INTO PROFILE VALUES('20000002','Apple', 24, 'Vancouver', 'Female', '10000002');
INSERT INTO PROFILE VALUES('20000003','Cindy', 26, 'Vancouver', 'Female', '10000003');
INSERT INTO PROFILE VALUES('20000004','Andy', 27, 'Vancouver', 'Male', '10000004');
INSERT INTO PROFILE VALUES('20000005','Scarlette', 21, 'Richmond', 'Female', '10000005');
INSERT INTO PROFILE VALUES('20000006','Linda', 20, 'Burnaby', 'Female', '10000006');
INSERT INTO PROFILE VALUES('20000007','Jude', 19, 'Vancouver', 'Female', '10000007');
INSERT INTO PROFILE VALUES('20000008','Steven', 22, 'Vancouver', 'Male', '10000008');
INSERT INTO PROFILE VALUES('20000009','Taylor', 22, 'Vancouver', 'Female', '10000009');
INSERT INTO PROFILE VALUES('20000010','Andy', 22, 'Vancouver', 'M', '10000010');
INSERT INTO LOGIN VALUES('31.86.129.184','2017-07-23 12:55:49','10000001');
INSERT INTO LOGIN VALUES('209.217.137.241','2008-11-11 13:23:44','10000002');
INSERT INTO LOGIN VALUES('254.171.35.211','2008-07-09 15:45:21','10000003');
INSERT INTO LOGIN VALUES('177.230.192.56','1998-06-11 11:12:01','10000004');
INSERT INTO LOGIN VALUES('115.142.93.27','2008-05-11 06:12:45','10000005');
INSERT INTO LOGIN VALUES('31.86.129.184','2015-04-11 03:12:44','10000006');
INSERT INTO LOGIN VALUES('31.86.129.184','2014-03-11 09:12:23','10000007');
INSERT INTO LOGIN VALUES('31.86.129.184','2013-02-11 11:12:59','10000008');
INSERT INTO LOGIN VALUES('31.86.129.184','2012-12-11 12:12:50','10000009');
INSERT INTO LOGIN VALUES('31.86.129.184','2011-01-11 05:12:02','10000010');


insert into App_User values
( 'u0000001', 'abc12345678');

insert into App_User values
( 'u0000002', 'abc12345678');

insert into App_User values
( 'u0000003', 'abc12345678');

insert into App_User values
( 'u0000004', 'abc12345678');

insert into App_User values
( 'u0000005', 'abc12345678');

insert into App_User values
( 'sp000003', 'hello');

insert into App_User values
( 'u0000006', 'abc12345678');

insert into App_User values
( 'u0000007', 'abc12345678');

insert into App_User values
( 'u0000008', 'abc12345678');

insert into App_User values
( 'u0000009', '123faef45678');

insert into App_User values
( 'u0001001', 'UBC_CPSC');

insert into App_User values
( 'u0001002', 'Orange.Inc');

insert into App_User values
( 'u0001003', 'Petnotsmart');

insert into App_User values
( 'u0001004', 'City Of Raincouver');

insert into App_User values
( 'u0001005', 'Professor Ad Nuoer');

insert into App_User values
( 'u0001006', 'RVR airport');

insert into App_User values
( 'u0001007', 'Macrosoft');

insert into App_User values
( 'u0001008', 'Monsterism');

insert into App_User values
( 'u0001009', 'Pooiation');

insert into App_User values
( 'u0001010', ' Students');

insert into Profile values
( 'p0000001', 'Mandy', 21, 'Vancouver, BC, Canada', 'Female' ,'u0000001');

insert into Profile values
( 'p0000002', 'Amy', 22, 'Burnaby, BC, Canada', 'Female', 'u0000002');

insert into Profile values
( 'p0000003', 'Bob', 23, 'Delta, BC, Canada', 'Male', 'u0000003');

insert into Profile values
( 'p0000004', 'Cathy', 24, 'Richmond, BC, Canada', 'Female', 'u0000004');

insert into Profile values
( 'p0000005', 'Dinnes', 25, 'Vancouver, BC, Canada', 'Male', 'u0000005');

insert into Profile values
( 'p0000006', 'Emma', 26, 'Burnaby, BC, Canada', 'Female', 'u0000008');


insert into Login values
( '199.175.213.12', '2018-02-19 8:00:00', 'u0000001');

insert into Login values
( '142.58.228.39', '2018-01-31 23:00:01','u0000002');

insert into Login values
( '207.81.228.29', '2018-01-30 10:10:00', 'u0000003');

insert into Login values
( '70.79.241.222', '2018-01-29 20:00:00', 'u0000004');

insert into Login values
( '199.175.213.12', '2018-02-10 16:40:40', 'u0000005');

insert into Login values
( '142.58.228.39', '2018-02-03 17:00:30', 'u0000008');


insert into Message values
( 'msg00001', 'Hello');

insert into Message values
( 'msg00002', 'How are you?');

insert into Message values
( 'msg00003', 'Hello world');

insert into Message values
( 'msg00004', 'I love you');

insert into Message values
( 'msg00005', 'God bless you');

insert into Message values
( 'msg00006', 'What''s up');

insert into Message values
( 'msg00007', 'Bye-bye');

insert into Send_Message values
( 'msg00001', 'u0000003', 'u0000005');

insert into Send_Message values
( 'msg00002', 'u0000005', 'u0000003');

insert into Send_Message values
( 'msg00001', 'u0000004', 'u0000003');

insert into Send_Message values
( 'msg00003', 'u0000003', 'u0000004');

insert into Send_Message values
( 'msg00001', 'u0000007', 'u0000008');

insert into Send_Message values
( 'msg00002', 'u0000004', 'u0000003');

insert into Send_Message values
( 'msg00003', 'u0000002', 'u0000001');


insert into Category values
( 'Sales', 'find discount everywhere');

insert into Category values
( 'Snack', 'share the most delicious food');

insert into Category values
( 'Pet', 'show off your lovely pet');

insert into Category values
( 'School', 'UBC is the best school');

insert into Category values
( 'Roomate', 'tell us about your roommate');

insert into Category values
( 'Weather', 'how is today');

insert into Category values
( 'Game', 'interesting games');

insert into Category values
( 'Makeup', 'the thing makes you more confident');

insert into Category values
( 'Sports', 'atheletes, competitions, and winners');

insert into Category values
( 'Electronics', 'ios or Android?');

insert into Category values
( 'Children', 'how to feed a young Homo sapiens');

insert into Category values
( 'Parents', 'how to fight with mom and dad');

insert into Post values
( 'post0001', 'Raincouver Weather', '2018-01-01 00:00:01','weather is greate today!', 'u0000005');

insert into Post values
( 'post0002', 'Raincouver Weather', '2018-02-01 00:00:02','weather is bad today!', 'u0000002');

insert into Post values
( 'post0003', 'How to feed a husky', '2018-01-01 00:00:03','Husky looks soooooo coollllll', 'u0000003');

insert into Post values
( 'post0004', 'My child does not talk with me', '2018-02-01 00:00:01','I am so sad about that', 'u0000008');

insert into Post values
( 'post0005', 'I do not want to talk with my dad', '2018-01-01 00:00:01','I prefer to stay my boyfriend', 'u0000004');

insert into Post values
( 'post0006', 'Do not try to feed a husky', '2018-02-01 00:00:01','They are the most stupid dogs in the word', 'u0000009');

insert into Post values
( 'post0007', 'Maybe you can chat with your child online', '2018-02-01 00:00:01','I found her in parents catergory', 'u0000007');

insert into Post values
( 'post0008', 'OHHHHHH no when does she has a boyfriend???', '2018-02-01 00:00:01','I cannot believe that', 'u0000008');

insert into Post values
( 'post0009', 'Come and look my new puppy', '2018-02-01 00:00:01','Husky is so cute', 'u0000003');

insert into Post values
( 'post0010', 'I think cats are more cute than dogs', '2018-02-01 00:00:01','Husky is so cute', 'u0000009');

insert into Post values
( 'post1001', 'Apply for UBC CPSC', '2018-02-01 00:00:01','Best cs program in the world', 'u0001001');

insert into Post values
( 'post1002', 'New orange pad pro is released', '2018-02-01 00:00:01','Only cost 10000000 dollar', 'u0001002');

insert into Post values
( 'post1003', 'We have the most cute Husky babies', '2018-02-01 00:00:01','time will tell', 'u0001003');

insert into Post values
( 'post1004', 'Accurate rain forecast', '2018-02-01 00:00:01','Next month will keep raining', 'u0001004');

insert into Post values
( 'post1005', 'CPSC 304 review session', '2018-02-01 00:00:01','Help you get 100 in the final', 'u0001005');

insert into Post values
( 'post1006', 'Flying ticket on sell', '2018-02-01 00:00:01','1 dollar per ticket', 'u0001006');

insert into Post values
( 'post1007', 'Macrosoft office software', '2018-02-01 00:00:01','Makes you work well', 'u0001007');

insert into Post values
( 'post1008', 'FSM', '2018-02-01 00:00:01','Join us', 'u0001008');

insert into Post values
( 'post1009', 'Join Poor CS Students Protection Association', '2018-02-01 00:00:01','Fight for cs studens human right', 'u0001009');

insert into Post values
( 'post1010', 'Hair', '2018-02-01 00:00:01','Make you more hair', 'u0001010');

insert into Post_Category values
( 'post0001', 'Weather');

insert into Post_Category values
( 'post0002', 'Weather');

insert into Post_Category values
( 'post0003', 'Pet');

insert into Post_Category values
( 'post0004', 'Children');

insert into Post_Category values
( 'post0005', 'Pet');

insert into Post_Category values
( 'post0006', 'Pet');

insert into Post_Category values
( 'post0007', 'Children');

insert into Post_Category values
( 'post0008', 'Parents');

insert into Post_Category values
( 'post0009', 'Pet');

insert into Post_Category values
( 'post0010', 'Pet');

insert into App_Comment values
( 'u0000001', 'post1002', '3','2018-01-01 00:00:01','how to fight with mom and dad');

insert into App_Comment values
( 'u0000002', 'post1003', '3','2018-01-01 00:00:01','how to fight with mom and dad');

insert into App_Comment values
( 'u0000003', 'post1005', '3','2018-01-01 00:00:01','hahahhaha');

insert into App_Comment values
( 'u0000001', 'post1002', '4','2018-01-01 00:00:01','how to fight with mom and dad');

insert into Advertisement values
('post1001', 1000000,'UBC CPSC department');

insert into Advertisement values
('post1002', 1000000,'Orange Technology');

insert into Advertisement values
('post1003', 1000000,'Petnotsmart');

insert into Advertisement values
('post1004', 1000000,'City of Raincouver');

insert into Advertisement values
('post1005', 1000000,'Professor Ad Nuoer');

insert into Advertisement values
('post1006', 1000000,'RVR airport');

insert into Advertisement values
('post1007', 1000000,'Macrosoft');

insert into Advertisement values
('post1008', 1000000,'Flying Spaghetti Monsterism');

insert into Advertisement values
('post1009', 1000000,'Poor CS Student Association');

insert into Advertisement values
('post1010', 1000000,'Legend of Lost Hair CS Student');

insert into Supervisor values
('sp000001', 'Jade');

insert into Supervisor values
('sp000002', 'Peichen');

insert into Supervisor values
('sp000003', 'Linda');

insert into Supervisor values
('sp000004', 'Heihei');

insert into Supervisor values
('sp000005', 'Pet cat of Jade');

insert into Supervisor values
('sp000006', 'Laptop');

insert into Supervisor values
('sp000007', 'hweifuaui');

insert into Supervisor values
('sp000008', 'aefaoij');

insert into Supervisor values
('sp000009', 'afeoifan');

insert into Supervisor values
('sp000010', 'faneoif');

insert into Supervise values
('sp000001', 'u0000005', 'post0001');

insert into Supervise values
('sp000002', 'u0000002', 'post0002');

insert into Supervise values
('sp000003', 'u0000003', 'post0003');

insert into Supervise values
('sp000004', 'u0000008', 'post0004');

insert into Supervise values
('sp000005', 'u0000004', 'post0005');

insert into Supervise values
('sp000006', 'u0000009', 'post0006');

insert into Supervise values
('sp000007', 'u0000007', 'post0007');

insert into Supervise values
('sp000008', 'u0000008', 'post0008');

insert into Supervise values
('sp000009', 'u0000003', 'post0009');

insert into Supervise values
('sp000010', 'u0000009', 'post0010');

insert into Supervise values
('sp000001', 'u0001001', 'post1001');

insert into Supervise values
('sp000002', 'u0001002', 'post1002');

insert into Supervise values
('sp000003', 'u0001003', 'post1003');

insert into Supervise values
('sp000004', 'u0001004', 'post1004');

insert into Supervise values
('sp000005', 'u0001005', 'post1005');

insert into Supervise values
('sp000006', 'u0001006', 'post1006');

insert into Supervise values
('sp000007', 'u0001007', 'post1007');

insert into Supervise values
('sp000008', 'u0001008', 'post1008');

insert into Supervise values
('sp000009', 'u0001009', 'post1009');

insert into Supervise values
('sp000010', 'u0001010', 'post1010');


commit;




