CREATE TABLE IF NOT EXISTS `user_x_pizza_x_topping` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `pizza_id` int NOT NULL,
    `topping_id` int NOT NULL,
    `user_id` int NOT NULL

);

ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_pizza  FOREIGN  KEY  (pizza_id)
REFERENCES  pizza  (id);


ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_topping  FOREIGN  KEY  (topping_id)
REFERENCES  topping  (id);


ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_user FOREIGN  KEY  (user_id)
REFERENCES  users  (id);