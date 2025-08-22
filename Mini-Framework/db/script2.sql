CREATE TABLE pays(
   id_pays SERIAL,
   nom_pays VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_pays)
);

CREATE TABLE villes(
   id_ville SERIAL,
   nom_ville VARCHAR(50)  NOT NULL,
   id_pays INTEGER NOT NULL,
   PRIMARY KEY(id_ville),
   FOREIGN KEY(id_pays) REFERENCES pays(id_pays)
);

CREATE TABLE types_siege(
   id_type_siege SERIAL,
   nom_type_siege VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_type_siege)
);

CREATE TABLE trajets(
   id_trajet SERIAL,
   id_depart INTEGER NOT NULL,
   id_arrivee INTEGER NOT NULL,
   PRIMARY KEY(id_trajet),
   FOREIGN KEY(id_depart) REFERENCES villes(id_ville),
   FOREIGN KEY(id_arrivee) REFERENCES villes(id_ville)
);

CREATE TABLE avions(
   id_avion SERIAL,
   nom_avion VARCHAR(50)  NOT NULL,
   siege_economique SMALLINT NOT NULL,
   siege_business SMALLINT NOT NULL,
   PRIMARY KEY(id_avion)
);

CREATE TABLE vols(
   id_vol SERIAL,
   date_depart TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   date_arrivee TIMESTAMP,
   id_trajet INTEGER NOT NULL,
   id_avion INTEGER NOT NULL,
   PRIMARY KEY(id_vol),
   UNIQUE(id_avion),
   FOREIGN KEY(id_trajet) REFERENCES trajets(id_trajet),
   FOREIGN KEY(id_avion) REFERENCES avions(id_avion)
);

CREATE TABLE statuts(
   id_statut SERIAL,
   nom_statut VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_statut)
);

CREATE TABLE roles(
   id_role SERIAL,
   nom_role VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_role)
);

CREATE TABLE types_frais(
   id_type_frais SERIAL,
   nom_type_frais VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_type_frais)
);

CREATE TABLE frais_trajets(
   id_frais_trajet SERIAL,
   frais NUMERIC(18,2)   NOT NULL,
   date_changement DATE NOT NULL DEFAULT CURRENT_DATE,
   id_type_frais INTEGER NOT NULL,
   id_trajet INTEGER NOT NULL,
   PRIMARY KEY(id_frais_trajet),
   FOREIGN KEY(id_type_frais) REFERENCES types_frais(id_type_frais),
   FOREIGN KEY(id_trajet) REFERENCES trajets(id_trajet)
);

CREATE TABLE categories_ages(
   id_categorie_age SERIAL,
   nom_categorie_age VARCHAR(50)  NOT NULL,
   age_min SMALLINT NOT NULL,
   age_max SMALLINT NOT NULL,
   PRIMARY KEY(id_categorie_age)
);

CREATE TABLE utilisateurs(
   id_utilisateur SERIAL,
   nom VARCHAR(50)  NOT NULL,
   prenom VARCHAR(50)  NOT NULL,
   email VARCHAR(50) ,
   mot_de_passe VARCHAR(250)  NOT NULL,
   id_role INTEGER NOT NULL DEFAULT 2,
   PRIMARY KEY(id_utilisateur),
   UNIQUE(email),
   FOREIGN KEY(id_role) REFERENCES roles(id_role)
);

CREATE TABLE config_frais(
   id_config SERIAL,
   pourcentage NUMERIC(15,2)   NOT NULL,
   date_debut DATE,
   date_fin DATE,
   id_categorie_age INTEGER NOT NULL,
   PRIMARY KEY(id_config),
   FOREIGN KEY(id_categorie_age) REFERENCES categories_ages(id_categorie_age)
);

CREATE TABLE reservations(
   id_reservation SERIAL,
   nom_complet VARCHAR(120)  NOT NULL,
   cin VARCHAR(15)  NOT NULL,
   telephone VARCHAR(15)  NOT NULL,
   nombre_place INTEGER NOT NULL,
   nombre_enfant INTEGER NOT NULL,
   place_business INTEGER NOT NULL,
   place_economique INTEGER NOT NULL,
   id_statut INTEGER NOT NULL DEFAULT 1,
   id_vol INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_reservation),
   FOREIGN KEY(id_statut) REFERENCES statuts(id_statut),
   FOREIGN KEY(id_vol) REFERENCES vols(id_vol),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id_utilisateur)
);
