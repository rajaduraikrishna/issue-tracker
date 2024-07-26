);
CREATE TABLE app_user (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` text,
  PRIMARY KEY (`id`)
);

-- mydb.roles definition

CREATE TABLE roles (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

-- mydb.user_roles definition

CREATE TABLE user_roles (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  KEY `FK6fql8djp64yp4q9b3qeyhr82b` (`user_id`),
  CONSTRAINT `FK6fql8djp64yp4q9b3qeyhr82b` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE issue (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(80),
    description TEXT,
    PRIMARY KEY ( id )
);
