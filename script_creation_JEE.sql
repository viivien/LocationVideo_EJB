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

INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('American Pie', "Mortifi� pour avoir �t� surpris par ses parents devant un film X, Jim, �l�ve de terminale, fait un pacte avec sa bande de copains: devenir des hommes avant l'entr�e � la fac. Il leur reste trois semaines pour utiliser toutes les techniques possibles de s�duction. Tous les moyens sont bons, meme les plus inattendus, car chaque jour compte. Une chose est s�re, Jim ne regardera plus jamais une tarte aux pommes de la m�me fa�on!",
95, '08/12/1999', 4);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('The Dark Knight', "Dans ce nouveau volet, Batman augmente les mises dans sa guerre contre le crime. Avec l'appui du lieutenant de police Jim Gordon et du procureur de Gotham, Harvey Dent, Batman vise � �radiquer le crime organis� qui pullule dans la ville. Leur association est tr�s efficace mais elle sera bient�t boulevers�e par le chaos d�clench� par un criminel extraordinaire que les citoyens de Gotham connaissent sous le nom de Joker.",
147, '13/08/2008', 2);
INSERT INTO VIDEO (vid_titre, vid_synopsis, vid_duree, vid_datesortie, vid_idcat) VALUES ('REC', "Ang�la est journaliste pour une t�l�vision locale. Accompagn�e de son cam�raman, elle relate le quotidien de ceux qui travaillent la nuit. 
Ce soir, elle est dans une caserne de pompiers. La nuit est calme, aucune urgence. Jusqu'au coup de fil d'une vieille dame qui r�clame du secours. Le tandem suit les pompiers et d�couvre en arrivant sur place des voisins tr�s inquiets. D'horribles cris ont �t� entendus dans l'appartement de la vieille dame. Ang�la per�oit la tension des habitants, son reportage devrait enfin sortir de la routine... Elle n'imagine pas � quel point !",
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
INSERT INTO CATEGORIE(cat_libelle) VALUES('Com�die');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Romance');

/*
INSERT INTO CLIENT(cli_nom, cli_prenom, cli_datedenaissance, cli_adresse, cli_ville, cli_cp, cli_telephone, cli_email, cli_password)
VALUES('CLAUDE', 'Jean', '01/01/1985', '1 rue de l� bas', 'Bordeaux', '33000', '0512590285', 'jclaude@test.com', md5(
 A CONTINUER */

