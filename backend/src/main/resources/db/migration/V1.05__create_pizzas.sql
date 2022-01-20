CREATE TABLE IF NOT EXISTS `pizza` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `price` int,
    `type` varchar(50)




);

INSERT INTO pizza (id,name, price, type) VALUES ('1', 'Salame', 15, 'NEAPOLITAN');
INSERT INTO pizza (id,name, price, type) VALUES ('2', 'Diablo', 24, 'NORMAL');
INSERT INTO pizza (id,name, price, type) VALUES ('3', 'Popcorn', 24, 'NEAPOLITAN');
INSERT INTO pizza (id,name, price, type) VALUES ('4', 'Mozart', 55, 'NORMAL');
INSERT INTO pizza (id,name, price, type) VALUES ('5', 'Jamaican', 23, 'NEAPOLITAN');
INSERT INTO pizza (id,name, price, type) VALUES ('6', 'Watergate', 16, 'NORMAL');

