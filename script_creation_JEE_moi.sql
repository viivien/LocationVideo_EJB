﻿CREATE TABLE TYPEPAIEMENT (
	typpai_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	typpai_libelle VARCHAR(30) NOT NULL
);

INSERT INTO TYPEPAIEMENT(typpai_libelle) VALUES('Carte Bancaire');
INSERT INTO TYPEPAIEMENT(typpai_libelle) VALUES('Carte Video Club');

CREATE TABLE CATEGORIE (
	cat_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	cat_libelle VARCHAR(50) NOT NULL
);

INSERT INTO CATEGORIE(cat_libelle) VALUES('Thriller');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Action');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Epouvante/Horreur');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Comédie');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Romance');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Science fiction');

CREATE TABLE VIDEO (
	vid_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	vid_titre VARCHAR(100) NOT NULL,
	vid_synopsis VARCHAR(500) NOT NULL,
	vid_duree INTEGER NOT NULL,
	vid_datesortie DATETIME NOT NULL,
	vid_prix FLOAT NOT NULL,
	vid_idcat INTEGER NOT NULL,
	CONSTRAINT FK_CATEGORIE FOREIGN KEY(vid_idcat) REFERENCES CATEGORIE(cat_id)
);

INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) VALUES ('American Pie', 'Mortifié pour avoir été surpris par ses parents devant un film X, Jim, élève de terminale, fait un pacte avec sa bande de copains: devenir des hommes avant l''entrée à la fac. Il leur reste trois semaines pour utiliser toutes les techniques possibles de séduction. Tous les moyens sont bons, meme les plus inattendus, car chaque jour compte. Une chose est sûre, Jim ne regardera plus jamais une tarte aux pommes de la même façon!',
95, '1999-12-08', 5.00, 4);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) VALUES ('The Dark Knight', 'Dans ce nouveau volet, Batman augmente les mises dans sa guerre contre le crime. Avec l''appui du lieutenant de police Jim Gordon et du procureur de Gotham, Harvey Dent, Batman vise à éradiquer le crime organisé qui pullule dans la ville. Leur association est très efficace mais elle sera bientôt bouleversée par le chaos déclenché par un criminel extraordinaire que les citoyens de Gotham connaissent sous le nom de Joker.',
147, '2008-08-13', 3.50, 2);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) VALUES ('REC', 'Angéla est journaliste pour une télévision locale. Accompagnée de son caméraman, elle relate le quotidien de ceux qui travaillent la nuit. 
Ce soir, elle est dans une caserne de pompiers. La nuit est calme, aucune urgence. Jusqu''au coup de fil d''une vieille dame qui réclame du secours. Le tandem suit les pompiers et découvre en arrivant sur place des voisins très inquiets. D''horribles cris ont été entendus dans l''appartement de la vieille dame. Angéla perçoit la tension des habitants, son reportage devrait enfin sortir de la routine... Elle n''imagine pas à quel point !',
80, '2008-04-23', 4.00, 3);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) 
VALUES ('Dark Shadows', 'En l''an 1752, Joshua et Naomi Collins partent de Liverpool, et prennent la mer avec leur jeune fils Barnabas, pour commencer une nouvelle vie en Amérique. Mais même un océan ne va pas suffire à les éloigner de la mystérieuse malédiction qui fait le malheur de leur famille.Vingt années passent, Barnabas est riche, puissant,c''est un séducteur invétéré jusqu''à ce qu''il commette la grave erreur de briser le coeur d''Angelique Bouchard, une sorcière, dans tous les sens du terme, qui lui jette un sort plus maléfique que la mort : celui d''être transformé en vampire et enterré vivant. Deux siècles plus tard, Barnabas est libéré de sa tombe par inadvertance et débarque en 1972 dans un monde totalement transformé. Il retourne à Collinwood Manor pour découvrir que son domaine, autrefois grandiose, est tombé en ruine.',
112, '2012-05-09', 8.00, 6);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) 
VALUES ('The Avengers', 'Poursuivant les spectaculaires aventures initiées par Iron man, L''incroyable Hulk, Thor et Captain America, Avengers - basé sur la très populaire bande dessinée Marvel parue en 1963 -constitue l''équipe ultime de super-héros et les réunit pour la première fois à l''écran. Lorsqu''un ennemi inattendu menace la sécurité du monde, Nick Fury, le directeur du SHIELD (l''agence internationale de maintien de la paix) monte de toutes pièces une équipe capable de préserver l''humanité du chaos',
142, '2012-04-25', 8.00, 2);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) 
VALUES ('Sans identité', 'Alors qu''il est à Berlin pour donner une conférence, un homme tombe dans le coma, victime d''un accident de voiture. Plus tard, une fois réveillé, il apprend qu''un autre homme a pris son identité et cherche à le tuer. Avec l''aide d’une jeune femme, il va tout mettre en oeuvre pour prouver qui il est.',
110, '2011-03-02', 5.00, 1);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_prix, vid_idcat) 
VALUES ('Je te promets', 'Inspiré d''une histoire vraie, le film se penche sur la détresse d''un homme dont l''épouse a perdu la mémoire après un accident de voiture. Désemparé, il fait tout pour reconquérir le coeur de sa belle.',
110, '2012-05-16', 5.00, 5);

CREATE TABLE CLIENT (
	cli_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	cli_nom VARCHAR(50) NOT NULL,
	cli_prenom VARCHAR(50) NOT NULL,
	cli_datedenaissance DATETIME NOT NULL,
	cli_adresse VARCHAR(100) NOT NULL,
	cli_ville VARCHAR(100) NOT NULL,
	cli_cp VARCHAR(5) NOT NULL,
	cli_telephone VARCHAR(10) NOT NULL,
	cli_email VARCHAR(100) NOT NULL,
	cli_password VARCHAR(200) NOT NULL
);

INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('BRUNETEAU', 'Clément', '1918-11-11', 'chez lui', 'Bordeaux', '33000', '0607080910', 'clement@epsi.fr', 'clement');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('CICCOLINI', 'Olivier', '2009-05-19', 'chez lui', 'Bordeaux', '33000', '0607080910', 'olivier@epsi.fr', 'olivier');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('CIER FOC', 'Glenn', '1800-09-13', 'chez lui', 'Bordeaux', '33000', '0607080910', 'glenn@epsi.fr', 'glenn');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('FONGUE', 'Cédric', '1789-01-01', 'chez lui', 'Bordeaux', '33000', '0607080910', 'cedric@epsi.fr', 'cedric');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('POIRIER', 'Vivien', '2000-12-08', 'chez lui', 'Bordeaux', '33000', '0607080910', 'vivien@epsi.fr', 'vivien');

CREATE TABLE EXEMPLAIRE (
	exe_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	exe_dateachat DATETIME NOT NULL,
	exe_idvideo INTEGER NOT NULL,
	CONSTRAINT FK_VIDEO FOREIGN KEY(exe_idvideo) REFERENCES VIDEO(vid_id)
);

INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2009-01-10', 1);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2009-01-10', 1);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2009-01-10', 1);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2010-04-14', 2);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2010-04-14', 2);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2010-04-14', 2);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 3);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 3);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 3);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 4);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 4);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 4);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 5);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 5);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 5);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 6);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 6);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 6);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 7);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 7);
INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES ('2008-09-27', 7);

CREATE TABLE TYPEPAIEMENT (
	typpai_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	typpai_libelle VARCHAR(30) NOT NULL
);

INSERT INTO TYPEPAIEMENT(typpai_libelle) VALUES('Carte Bancaire');
INSERT INTO TYPEPAIEMENT(typpai_libelle) VALUES('Carte Video Club');

CREATE TABLE LOCATION (
	loc_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	loc_idclient INTEGER NOT NULL,
	loc_idexemplaire INTEGER NOT NULL,
	loc_date DATETIME NOT NULL,
	loc_prix DECIMAL(5,2) NOT NULL,
	loc_nbHeureLocation INTEGER NOT NULL,
	loc_idtyppai INTEGER NOT NULL,
	CONSTRAINT FK_CLIENT FOREIGN KEY(loc_idclient) REFERENCES CLIENT(cli_id),
	CONSTRAINT FK_TYPEPAIEMENT FOREIGN KEY(loc_idtyppai) REFERENCES TYPEPAIEMENT(typpai_id)
);

INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(1, 1, '2012-01-01', 3.00, 2, 1);
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(2, 2, '2012-02-02', 3.00, 2, 1);
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(3, 3, '2012-03-03', 3.00, 2, 2);
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(4, 1, '2012-03-03', 3.00, 3, 1);
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(5, 1, '2012-03-03', 3.00, 1, 2)
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(1, 4, '2012-04-03', 3.00, 3, 2);
INSERT INTO LOCATION (loc_idclient, loc_idexemplaire, loc_date, loc_prix, loc_nbHeureLocation, loc_idtyppai)
VALUES(4, 8, '2012-06-03', 3.00, 1, 1);