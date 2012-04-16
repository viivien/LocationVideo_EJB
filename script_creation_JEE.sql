CREATE TABLE CATEGORIE (
	cat_id INT NOT NULL AUTO_INCREMENT,
	cat_libelle VARCHAR(50) NOT NULL,
	CONSTRAINT PK_CATEGORIE PRIMARY KEY(cat_id)
);

CREATE TABLE VIDEO (
	vid_id INT NOT NULL AUTO_INCREMENT,
	vid_titre VARCHAR(100) NOT NULL,
	vid_synopsis VARCHAR(500) NOT NULL,
	vid_duree INT NOT NULL,
	vid_datesortie DATETIME NOT NULL,
	vid_idcat INT NOT NULL,
	CONSTRAINT PK_VIDEO PRIMARY KEY(vid_id),
	CONSTRAINT FK_CATEGORIE FOREIGN KEY(vid_idcat) REFERENCES CATEGORIE(cat_id)
);

INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('American Pie', "Mortifié pour avoir été surpris par ses parents devant un film X, Jim, élève de terminale, fait un pacte avec sa bande de copains: devenir des hommes avant l'entrée à la fac. Il leur reste trois semaines pour utiliser toutes les techniques possibles de séduction. Tous les moyens sont bons, meme les plus inattendus, car chaque jour compte. Une chose est sûre, Jim ne regardera plus jamais une tarte aux pommes de la même façon!",
95, '08/12/1999', 4);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('The Dark Knight', "Dans ce nouveau volet, Batman augmente les mises dans sa guerre contre le crime. Avec l'appui du lieutenant de police Jim Gordon et du procureur de Gotham, Harvey Dent, Batman vise à éradiquer le crime organisé qui pullule dans la ville. Leur association est très efficace mais elle sera bientôt bouleversée par le chaos déclenché par un criminel extraordinaire que les citoyens de Gotham connaissent sous le nom de Joker.",
147, '13/08/2008', 2);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('REC', "Angéla est journaliste pour une télévision locale. Accompagnée de son caméraman, elle relate le quotidien de ceux qui travaillent la nuit. 
Ce soir, elle est dans une caserne de pompiers. La nuit est calme, aucune urgence. Jusqu'au coup de fil d'une vieille dame qui réclame du secours. Le tandem suit les pompiers et découvre en arrivant sur place des voisins très inquiets. D'horribles cris ont été entendus dans l'appartement de la vieille dame. Angéla perçoit la tension des habitants, son reportage devrait enfin sortir de la routine... Elle n'imagine pas à quel point !",
80, '23/04/2008', 3);

CREATE TABLE CLIENT (
	cli_id INT NOT NULL AUTO_INCREMENT,
	cli_nom VARCHAR(50) NOT NULL,
	cli_prenom VARCHAR(50) NOT NULL,
	cli_datedenaissance DATETIME NOT NULL,
	cli_adresse VARCHAR(100) NOT NULL,
	cli_ville VARCHAR(100) NOT NULL,
	cli_cp VARCHAR(5) NOT NULL,
	cli_telephone VARCHAR(10) NOT NULL,
	cli_email VARCHAR(100) NOT NULL,
	cli_password VARCHAR(200) NOT NULL,
	CONSTRAINT PK_CLIENT PRIMARY KEY(cli_id)
);

CREATE TABLE EXEMPLAIRE (
	exe_id INT NOT NULL AUTO_INCREMENT,
	exe_dateachat DATETIME NOT NULL,
	exe_idvideo INT NOT NULL,
	CONSTRAINT PK_EXEMPLAIRE PRIMARY KEY(exe_id),
	CONSTRAINT FK_VIDEO FOREIGN KEY(exe_idvideo) REFERENCES VIDEO(vid_id)
);

CREATE TABLE LOCATION (
	loc_id INT NOT NULL AUTO_INCREMENT,
	loc_idclient INT NOT NULL,
	loc_idexemplaire INT NOT NULL,
	loc_date DATETIME NOT NULL,
	loc_prix DECIMAL(5,2) NOT NULL,
	loc_nbHeureLocation INT NOT NULL,
	CONSTRAINT PK_LOCATION PRIMARY KEY(loc_id),
	CONSTRAINT FK_CLIENT FOREIGN KEY(loc_idclient) REFERENCES CLIENT(cli_id)
	/*CONSTRAINT FK_EXEMPLAIRE FOREIGN KEY(loc_idvideo) REFERENCES VIDEO(vid_id)*/
);

INSERT INTO CATEGORIE(cat_libelle) VALUES('Thriller');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Action');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Epouvante/Horreur');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Comédie');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Romance');

/*
INSERT INTO CLIENT(cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES('CLAUDE', 'Jean', '01/01/1985', '1 rue de là bas', 'Bordeaux', '33000', '0512590285', 'jclaude@test.com', md5(
 A CONTINUER */

