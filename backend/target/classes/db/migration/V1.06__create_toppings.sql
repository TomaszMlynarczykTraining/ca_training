CREATE TABLE IF NOT EXISTS `topping` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `price` int,
    `type` varchar(50)




);

INSERT INTO topping (id,name, price, type) VALUES ('1', 'Salami', 4, 'MEAT');
INSERT INTO topping (id,name, price, type) VALUES ('2', 'Pepperoni', 2, 'VEGAN');
INSERT INTO topping (id,name, price, type) VALUES ('3', 'Anchois', 1, 'VEGAN');
INSERT INTO topping (id,name, price, type) VALUES ('4', 'Bacon', 5, 'MEAT');
INSERT INTO topping (id,name, price, type) VALUES ('5', 'Egg', 3, 'VEGAN');
INSERT INTO topping (id,name, price, type) VALUES ('6', 'Eggplant', 9, 'VEGAN');

