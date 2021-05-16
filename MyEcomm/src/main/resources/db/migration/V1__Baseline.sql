DROP TABLE IF EXISTS account;

CREATE TABLE account (
  accountid int(10) NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  firstname varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  password varchar(30) NOT NULL,
  isadmin bit NOT NULL,
  PRIMARY KEY (accountid)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES account WRITE;
INSERT INTO account VALUES (1,"email@email.com","Bob","Jones","abc123",0),(2,"email@email.com","Edward","Smith","abc123",0),(3,"email@email.com","Greg","Hoover","abc123",0),(4,"email@email.com","George","Washington","abc123",0),(5,"email@email.com","John","Adams","abc123",1),(6,"email@email.com","Ronald","Reagan","abc123",1);
UNLOCK TABLES;


DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  description varchar(500) NOT NULL,
  unitprice varchar(20) NOT NULL,
  unitsinstock int(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES product WRITE;
INSERT INTO product VALUES (1,"Coffee Maker","This coffee maker makes the best coffee in the entire world.",49.85,672),(2,"Space Heater","Make your house nice and warm.",99.43, 355),(3,"Light Bulb","Make your house nice and bright.",4.77, 453),(4,"Color Television","Watch your favorite shows on this color TV.", 199.96,274),(5,"Paper Towels Roll","Clean up tough messes with these paper towels.",3.63,856),(7,"Fan","Cool down with one of these fans.",39.99,474),(8,"Lawn Mower","Keep your lawn looking nice all summer long.",98.09,824),(9,"Electric Toothbrush","Keep your teeth clean with an electric toothbrush.",37.56,654),(10,"Basketball Goal","Become a star basketball player with one of these basketball goals.",96.97,456);
UNLOCK TABLES;


DROP TABLE IF EXISTS cart;

CREATE TABLE cart (
  accountid int(10) NOT NULL,
  productid int(10) NOT NULL,
  PRIMARY KEY (accountid,productid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES cart WRITE;
INSERT INTO cart VALUES (1,1),(2,5),(3,4),(5,2),(4,1),(6,5);
UNLOCK TABLES;


DROP TABLE IF EXISTS purchase;

CREATE TABLE purchase (
  purchaseid int(10) NOT NULL AUTO_INCREMENT,
  accountid int(10) NOT NULL,
  purchasedt varchar(8) NOT NULL,
  PRIMARY KEY (purchaseid)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES purchase WRITE;
INSERT INTO purchase VALUES (1,5,"04152021"),(2,3,"04032021"),(3,4,"04072021"),(4,1,"04012021"),(5,2,"04102021");
UNLOCK TABLES;


DROP TABLE IF EXISTS purchasedetails;

CREATE TABLE purchasedetails (
  purchaseid int(10) NOT NULL,
  productid varchar(10) NOT NULL,
  quantity varchar(10) NOT NULL,
  PRIMARY KEY (purchaseid,productid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES purchasedetails WRITE;
INSERT INTO purchasedetails VALUES (1,5,4),(2,3,7),(3,4,2),(4,1,11),(5,2,28);
UNLOCK TABLES;


DROP TABLE IF EXISTS billinginfo;

CREATE TABLE billinginfo (
  billingid int(10) NOT NULL AUTO_INCREMENT,
  purchaseid int(10) NOT NULL,
  billfirstname varchar(50) NOT NULL,
  billlastname varchar(50) NOT NULL,
  billingaddress varchar(100) NOT NULL,
  creditcardexpdate varchar(4) NOT NULL,
  creditcardpin varchar(3) NOT NULL,
  creditcardnum varchar(16) NOT NULL,
  creditcardname varchar(100) NOT NULL,
  PRIMARY KEY (billingid)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES billinginfo WRITE;
INSERT INTO billinginfo VALUES (1,4,"Bob","Jones","123 Main Street, Oklahoma City, OK, 73132","0122","123","1234567891234567","Bob Jones"),(2,2,"Bob","Jones", "123 Main Street, Oklahoma City, OK, 73132","0122","123","1234567891234567","Bob Jones"),(3,5,"Bob","Jones", "123 Main Street, Oklahoma City, OK, 73132","0122","123","1234567891234567","Bob Jones"),(4,1,"Bob","Jones", "123 Main Street, Oklahoma City, OK, 73132","0122","123","1234567891234567","Bob Jones"),(5,3,"Bob","Jones", "123 Main Street, Oklahoma City, OK, 73132","0122","123","1234567891234567","Bob Jones");
UNLOCK TABLES;