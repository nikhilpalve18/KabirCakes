use kabircakes;
show tables;
select * from products;

INSERT INTO products VALUES (1, 'Cakes','Chocolate','Awesome!',500,'Yes','C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\chocolate.jpg');
INSERT INTO products VALUES (5, 'minibites','Cup Cake','Awesome!',200,'Yes','C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\cupCakes.jpg');



INSERT INTO products VALUES (2, 'Cakes','Vanilla','Awesome!',300,'Yes','C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\vanilla.jpg');
INSERT INTO products VALUES (4, 'Cakes','Black Forest',' A cake that screams celebration! Black Forest gateau consists of
            several layers of chocolate sponge cake sandwiched with whipped
            cream and cherries. It is decorated with additional whipped cream.',600,'Yes','C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\Black Forest.jpg');


CREATE TABLE users (
	uId INT PRIMARY KEY auto_increment,
	uName VARCHAR(100),
    email VARCHAR(100) unique,
    mobileNumber VARCHAR(100),
    securityQuestion VARCHAR(100),
    answer VARCHAR(100),
    pass VARCHAR(100),
    address VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100)
);

CREATE TABLE products (
	prodId INT PRIMARY KEY auto_increment,
    category VARCHAR(100),
    prodName VARCHAR(100),
	prodDesc VARCHAR(100),
	prodPrice INT,
    status VARCHAR(100), 
    imageFileName VARCHAR(100)
);

CREATE TABLE cart (
	prodId INT,
    email VARCHAR(100),
    prodName VARCHAR(100),
    quantity INT, 
    price INT, 
    total INT
);

CREATE TABLE orders (
	orderId INT PRIMARY KEY auto_increment,
    email VARCHAR(100),
    paymentMode VARCHAR(100),
    transactionId varchar(100), 
    orderDate datetime, 
    shippingDate datetime
);

CREATE TABLE orderDetails (
	orderId INT ,
    productName VARCHAR(100),
    quantity INT
);


ALTER TABLE orders
MODIFY COLUMN shippingDate timestamp;

DROP TABLE orders;

CREATE TABLE orderDetails (
	orderId VARCHAR(100),
	email VARCHAR(100)
);

CREATE TABLE contactInfo(
	contactId INT PRIMARY KEY auto_increment,
    fullName VARCHAR(50),
    email VARCHAR(50),
    message VARCHAR(255)
);
DROP TABLE contactInfo;

desc users;
INSERT INTO users (uName, email, mobileNumber, securityQuestion, answer, pass, address, city, state, country)

SELECT uName, mobileNumber, users.email, orders.orderId, orders.paymentMode, orders.transactionId 
FROM users INNER JOIN orders ON users.email = orders.email
where orderId = 1;


DELIMITER //
create trigger mobileLengthValidationuserspassword
before insert On users
for each row
begin
if (length(NEW.mobileNumber) <> 10) then
signal sqlstate '-20000' set message_text = 'Mobile Number must me of 10 length!';
end if;
end // 







