DROP TABLE Person;

CREATE TABLE Person (
  id     NUMBER(10)  NOT NULL,
  firstname varchar2(255) NOT NULL,
  lastname varchar2(255),
  age NUMBER(10)  NOT NULL,
  email varchar2(255),
  address varchar2(255),
  phonenumber varchar2(255),
  ownership varchar2(255)
);

ALTER TABLE Person ADD (
  CONSTRAINT id PRIMARY KEY (ID));
CREATE SEQUENCE incrementtest;

CREATE OR REPLACE TRIGGER books_on_insert
  BEFORE INSERT ON Person
  FOR EACH ROW
BEGIN
  SELECT incrementtest.nextval
  INTO :new.id
  FROM dual;
END;

INSERT ALL
   INTO Person (firstname, lastname, age, email, address, phonenumber, ownership) VALUES ('username1', 'password1', 20, 'test1@gmail.com', 'test address1', '999-999-0001', 'yes')
   INTO Person (firstname, lastname, age, email, address, phonenumber, ownership) VALUES ('username2', 'password5', 21, 'test2@gmail.com', 'test address2', '999-999-0002', 'yes')
   INTO Person (firstname, lastname, age, email, address, phonenumber, ownership) VALUES ('username3', 'password3', 22, 'test3@gmail.com', 'test address3', '999-999-0003', 'yes')
   SELECT 1 FROM DUAL;
   