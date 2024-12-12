CREATE database harrypotter;

USE harrypotter;

CREATE TABLE book(
                     ID int NOT NULL AUTO_INCREMENT,
                     title VARCHAR(50),
                     description VARCHAR(255),
                     PRIMARY KEY (ID)
);

INSERT INTO book (title, description) VALUES ("Harry Potter à l'Ecole des Sorciers",
                                              "Que cache la trappe du troisième étage ?"),

                                             ("Harry Potter et la Chambre des Secrets",
                                              "Harry résoudra t'il le mystère de la chambre des secrets ?"),

                                             ("Harry Potter et le Prisonnier d'Azkaban",
                                              "Qui est Sirius Black ?"),

                                             ("Harry Potter et la coupe de feu",
                                              "Qui gagnera le tournoi des trois sorciers ?"),

                                             ("Harry Potter et l'ordre du Phénix",
                                              "Harry et ses amis réussiront-ils à sauver Sirius Black (Harry en a rêvé) ?"),

                                             ("Harry Potter et les reliques de la mort",
                                              "Harry parviendra-t-il à retrouver tous les horcruxes et à les détruire ?");

CREATE TABLE actor(
                      ID INT NOT NULL AUTO_INCREMENT,
                      lastname VARCHAR(50),
                      firstname VARCHAR(50),
                      birthdate DATE,
                      role VARCHAR(50),
                      PRIMARY KEY (ID)
);

INSERT INTO actor (LASTNAME, FIRSTNAME, BIRTHDATE, ROLE) VALUES
                                                             ("Radcliffe","Daniel","1989-07-23","Harry potter"),
                                                             ("Watson","Emma","1990-04-15","Hermione Granger"),
                                                             ("Grint","Rupert","1988-08-24","Ron Weasley"),
                                                             ("Rickman","Alan","1946-02-21","Severus Rogue"),
                                                             ("Felton","Tom","1987-09-22","Drago Malefoy"),
                                                             ("Wright","Bonnie","1991-02-17","Ginnie Weasley"),
                                                             ("Lewis","Matthew","1986-06-27","Neville Londubat"),
                                                             ("Gambon","Michael","1940-10-19","Albus Dumbledore");

CREATE TABLE movie(
                      ID INT NOT NULL AUTO_INCREMENT,
                      title VARCHAR(50),
                      yearOfRelease YEAR,
                      director VARCHAR(50),
                      description VARCHAR(100),
                      PRIMARY KEY(ID)
);

INSERT INTO movie (title, yearOfRelease,director, description) VALUES
                                                                   ("Harry Potter et la chambre des secrets",2002,"Chris Columbus","Dans les entrails de Poudlard, le mal se réveille"),
                                                                   ("Harry Potter et la chambre des secrets",2002,"Chris Columbus","Dans les entrails de Poudlard, le mal se réveille"),
                                                                   ("Harry Potter et le prisonnier d'azkaban",2004,"Alfonso Cuarón","Les secrets du passé gissent. Tout ce qui a été imaginé sera transformé"),
                                                                   ("Harry Potter et la coupe de feu",2005,"Mike Newell","Des heures sombres et difficiles s'annoncent"),
                                                                   ("Harry Potter et l'ordre du phénix",2007,"David Yates","La rébellion commence à Poudlard"),
                                                                   ("Harry Potter et le prince de sang-mêlé",2009,"David Yates","De sombres secrets dévoilés pour faire face à la bataille finale");