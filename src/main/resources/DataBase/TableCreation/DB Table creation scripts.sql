CREATE TABLE newDB.user (
 
  id bigint NOT NULL AUTO_INCREMENT,

  email varchar(255) DEFAULT NULL,

  name varchar(100) DEFAULT NULL,

  phone varchar(25) DEFAULT NULL,

  user_name varchar(100) DEFAULT NULL,

  website varchar(100) DEFAULT NULL,

  PRIMARY KEY (id)

);

CREATE TABLE newDB.address (

  user_id bigint NOT NULL,

  city varchar(100) DEFAULT NULL,

  street varchar(255) DEFAULT NULL,

  suite varchar(255) DEFAULT NULL,

  zipcode varchar(15) DEFAULT NULL,

  PRIMARY KEY (user_id),

  CONSTRAINT FK_1 FOREIGN KEY (user_id) REFERENCES user (id)

);

CREATE TABLE newDB.company (
 
  user_id bigint NOT NULL,

  bs varchar(255) DEFAULT NULL,

  catch_phrase varchar(255) DEFAULT NULL,

  name varchar(255) DEFAULT NULL,

  PRIMARY KEY (user_id),
  CONSTRAINT FK_2 FOREIGN KEY (user_id) REFERENCES user (id)

);

CREATE TABLE newDB.geo (

  address_id bigint NOT NULL,

  lat varchar(15) DEFAULT NULL,

  lng varchar(15) DEFAULT NULL,

  PRIMARY KEY (address_id),

  CONSTRAINT FK_3 FOREIGN KEY (address_id) REFERENCES address (user_id)

);

CREATE TABLE newDB.post (
 
  id bigint NOT NULL AUTO_INCREMENT,

  body varchar(255) DEFAULT NULL,

  title varchar(100) DEFAULT NULL,

  user_id bigint NOT NULL,

  PRIMARY KEY (id),

  CONSTRAINT FK_5 FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE

) 




