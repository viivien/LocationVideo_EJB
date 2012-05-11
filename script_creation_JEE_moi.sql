﻿CREATE TABLE CATEGORIE (
	cat_id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	cat_libelle VARCHAR(50) NOT NULL
);

INSERT INTO CATEGORIE(cat_libelle) VALUES('Thriller');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Action');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Epouvante/Horreur');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Comédie');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Romance');

CREATE TABLE VIDEO (
	vid_id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	vid_titre VARCHAR(100) NOT NULL,
	vid_synopsis VARCHAR(500) NOT NULL,
	vid_duree INT NOT NULL,
	vid_datesortie DATETIME NOT NULL,
	vid_idcat INT NOT NULL,
	CONSTRAINT FK_CATEGORIE FOREIGN KEY(vid_idcat) REFERENCES CATEGORIE(cat_id)
);

INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('American Pie', 'Mortifié pour avoir été surpris par ses parents devant un film X, Jim, élève de terminale, fait un pacte avec sa bande de copains: devenir des hommes avant l''entrée à la fac. Il leur reste trois semaines pour utiliser toutes les techniques possibles de séduction. Tous les moyens sont bons, meme les plus inattendus, car chaque jour compte. Une chose est sûre, Jim ne regardera plus jamais une tarte aux pommes de la même façon!',
95, '1999-12-08', 4);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('The Dark Knight', 'Dans ce nouveau volet, Batman augmente les mises dans sa guerre contre le crime. Avec l''appui du lieutenant de police Jim Gordon et du procureur de Gotham, Harvey Dent, Batman vise à éradiquer le crime organisé qui pullule dans la ville. Leur association est très efficace mais elle sera bientôt bouleversée par le chaos déclenché par un criminel extraordinaire que les citoyens de Gotham connaissent sous le nom de Joker.',
147, '2008-08-13', 2);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('REC', 'Angéla est journaliste pour une télévision locale. Accompagnée de son caméraman, elle relate le quotidien de ceux qui travaillent la nuit. 
Ce soir, elle est dans une caserne de pompiers. La nuit est calme, aucune urgence. Jusqu''au coup de fil d''une vieille dame qui réclame du secours. Le tandem suit les pompiers et découvre en arrivant sur place des voisins très inquiets. D''horribles cris ont été entendus dans l''appartement de la vieille dame. Angéla perçoit la tension des habitants, son reportage devrait enfin sortir de la routine... Elle n''imagine pas à quel point !',
80, '2008-04-23', 3);

CREATE TABLE CLIENT (
	cli_id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
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
VALUES ('BRUNETEAU', 'Clément', '1918-11-11', 'chez lui', 'Bordeaux', '33000', '0607080910', 'clem.ent@brune.teau', 'clement');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('CICCOLINI', 'Olivier', '2009-05-19', 'chez lui', 'Bordeaux', '33000', '0607080910', 'olivier@cicco.lini', 'olivier');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('CIER FOC', 'Glenn', '1800-09-13', 'chez lui', 'Bordeaux', '33000', '0607080910', 'glen.n@cier.foc', 'glenn');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('FONGUE', 'Cédric', '1789-01-01', 'chez lui', 'Bordeaux', '33000', '0607080910', 'ced.ric@fon.gue', 'cedric');
INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES ('POIRIER', 'Vivien', '2000-12-08', 'chez lui', 'Bordeaux', '33000', '0607080910', 'vivi.en@poir.ier', 'vivien');

CREATE TABLE EXEMPLAIRE (
	exe_id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	exe_dateachat DATETIME NOT NULL,
	exe_idvideo INT NOT NULL,
	CONSTRAINT FK_VIDEO FOREIGN KEY(exe_idvideo) REFERENCES VIDEO(vid_id)
);

CREATE TABLE LOCATION (
	loc_id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	loc_idclient INT NOT NULL,
	loc_idexemplaire INT NOT NULL,
	loc_date DATETIME NOT NULL,
	loc_prix DECIMAL(5,2) NOT NULL,
	loc_nbHeureLocation INT NOT NULL,
	CONSTRAINT FK_CLIENT FOREIGN KEY(loc_idclient) REFERENCES CLIENT(cli_id)
);