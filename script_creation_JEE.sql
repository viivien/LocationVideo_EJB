CREATE TABLE CATEGORIE (
	cat_id INT NOT NULL,
	cat_libelle VARCHAR(50) NOT NULL,
	CONSTRAINT PK_CATEGORIE PRIMARY KEY(cat_id)
);

CREATE TABLE VIDEO (
	v_id INT NOT NULL,
	v_titre VARCHAR(100) NOT NULL,
	v_synopsys VARCHAR(500) NOT NULL,
	v_duree INT NOT NULL,
	v_anneesortie VARCHAR(4) NOT NULL,
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

CREATE TABLE LOCATION (
	loc_id INT NOT NULL,
	loc_idclient INT NOT NULL,
	loc_idvideo INT NOT NULL,
	loc_date DATETIME NOT NULL,
	loc_prix DECIMAL(5,2) NOT NULL,
	loc_date DATETIME NOT NULL,
	CONSTRAINT PK_LOCATION PRIMARY KEY(loc_id),
	CONSTRAINT FK_CLIENT FOREIGN KEY(loc_idclient) REFERENCES CLIENT(cli_id),
	CONSTRAINT FK_VIDEO FOREIGN KEY(loc_idvideo) REFERENCES VIDEO(v_id)
);

INSERT INTO CATEGORIE(cat_libelle) VALUES('Thriller');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Action');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Epouvante/Horreur');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Com�die');
INSERT INTO CATEGORIE(cat_libelle) VALUES('Romance');

/* A CONTINUER */

