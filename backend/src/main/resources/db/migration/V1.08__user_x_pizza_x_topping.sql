CREATE TABLE IF NOT EXISTS `user_x_pizza_x_topping` (

    `pizza_id` int NOT NULL FOREIGN KEY,
    `topping_id` int NOT NULL FOREIGN KEY,
    `user_id` int NOT NULL FOREIGN KEY,

)

ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_pizza  FOREIGN  KEY  (pizza_id)
REFERENCES  pizza  (id);


ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_topping  FOREIGN  KEY  (topping_id)
REFERENCES  topping  (id);


ALTER  TABLE  user_x_pizza_x_topping ADD  CONSTRAINT  fk_ux_user FOREIGN  KEY  (user_id)
REFERENCES  user  (id);