CREATE TABLE CATEGORIE (
	cat_id INT NOT NULL,
	cat_libelle VARCHAR(50) NOT NULL,
	CONSTRAINT PK_CATEGORIE PRIMARY KEY(cat_id)
);

CREATE TABLE VIDEO (
	v_id INT NOT NULL,
	v_titre VARCHAR(100) NOT NULL,
	v_synopsis VARCHAR(500) NOT NULL,
	v_duree INT NOT NULL,
	v_datesortie DATETIME NOT NULL,
	v_idcat INT NOT NULL,
	CONSTRAINT PK_VIDEO PRIMARY KEY(v_id),
	CONSTRAINT FK_CATEGORIE FOREIGN KEY(v_idcat) REFERENCES CATEGORIE(cat_id)
);

CREATE TABLE CLIENT (
	cli_id INT NOT NULL,
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
	exe_id INT NOT NULL,
	exe_dateachat DATETIME NOT NULL,
	exe_idvideo INT NOT NULL,
	CONSTRAINT PK_EXEMPLAIRE PRIMARY KEY(exe_id),
	CONSTRAINT FK_VIDEO FOREIGN KEY(exe_idvideo) REFERENCES VIDEO(vid_id)
);

CREATE TABLE LOCATION (
	loc_id INT NOT NULL,
	loc_idclient INT NOT NULL,
	loc_idexemplaire INT NOT NULL,
	loc_date DATETIME NOT NULL,
	loc_prix DECIMAL(5,2) NOT NULL,
	loc_nbHeureLocation INT NOT NULL,
	CONSTRAINT PK_LOCATION PRIMARY KEY(loc_id),
	CONSTRAINT FK_CLIENT FOREIGN KEY(loc_idclient) REFERENCES CLIENT(cli_id),
	CONSTRAINT FK_EXEMPLAIRE FOREIGN KEY(loc_idvideo) REFERENCES VIDEO(v_id)
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

