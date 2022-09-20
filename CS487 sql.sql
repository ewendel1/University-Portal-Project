CREATE TABLE Students (
  ID int,
  Name Varchar(50),
  Email Varchar(50),
  Sex Varchar(8),
  PhoneNumber Int,
  Password Varchar(24),
  PRIMARY KEY (ID)
);

CREATE TABLE Professor (
  ID int,
  Name Varchar(50),
  Email Varchar(50),
  Sex Varchar(8),
  PhoneNumber Int,
  Password Varchar(24),
  PRIMARY KEY (ID)
);

CREATE TABLE Staff (
  ID int,
  Name Varchar(50),
  Email Varchar(50),
  Sex Varchar(8),
  PhoneNumber Int,
  Password Varchar(24),
  PRIMARY KEY (ID)
);

CREATE TABLE Admin (
  ID int,
  Name Varchar(50),
  Email Varchar(50),
  Sex Varchar(8),
  PhoneNumber Int,
  Password Varchar(24),
  PRIMARY KEY (ID)
);

CREATE TABLE Courses (
  ID int,
  Class Varchar(50),
  Professor Varchar(24),
  Grade int,
  PRIMARY KEY (ID)
);

CREATE TABLE Jobs (
  ID int,
  Company Varchar(50),
  Hiring Varchar(24),
  Pay int,
  PRIMARY KEY (ID)
);

select * from Students group by EMAIL;
select * from Students union select * from Professor union select * from Staff union select * from Admin;

select PASSWORD from Students union select PASSWORD from Professor union select PASSWORD from Staff union select PASSWORD from Admin where EMAIL='dhood@hawk.iit.edu';
select * from Students union select * from Professor union select * from Staff union select * from Admin where EMAIL='dhood@hawk.iit.edu';


select * from Students;






