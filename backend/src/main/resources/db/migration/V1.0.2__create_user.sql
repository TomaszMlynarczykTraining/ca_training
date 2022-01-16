CREATE TABLE IF NOT EXISTS `users` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` varchar(20),
    `last_name` varchar(50),
    `email_id` varchar(50),
    `login` varchar(50),
    `password` varchar(50),
    `is_logged` varchar(1)



)