CREATE TABLE IF NOT EXISTS `product` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `price` int,
    `description` varchar(50)




);

INSERT INTO product (id,name, price, description) VALUES ('1', 'A.Zamów fracht', 200, 'Zamów przewóz morski');
INSERT INTO product (id,name, price, description) VALUES ('2', 'B.Zamów samochód', 100, 'Zamów przewóz samochodem');
INSERT INTO product (id,name, price, description) VALUES ('3', 'C.Zamów samolot', 2300, 'Zamów przewóz lotniczy');
INSERT INTO product (id,name, price, description) VALUES ('4', 'D.Zamów tira', 200, 'Zamów przewóz całopojazdowy');

