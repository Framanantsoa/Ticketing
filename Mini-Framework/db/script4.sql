INSERT INTO pays (nom_pays) VALUES 
('Madagascar'), 
('Maurice'), 
('La Réunion'), 
('France');

INSERT INTO types_siege (nom_type_siege) VALUES
('Business'), 
('Économique');

INSERT INTO categories_ages (nom_categorie_age, age_min, age_max) VALUES
('Bébé', 0, 2),
('Enfant', 3, 12),
('Adulte', 13, 120);

INSERT INTO statuts (nom_statut) VALUES
('En attente'), 
('Validé'), 
('Annulé'), 
('Refusé');

INSERT INTO roles (nom_role) VALUES
('Administrateur'), 
('Utilisateur');

INSERT INTO types_frais (nom_type_frais) VALUES
('Économique'), ('Business');

INSERT INTO villes (nom_ville, id_pays) VALUES
('Antananarivo', 1), ('Toamasina', 1), ('Mahajanga', 1),
('Port-Louis', 2), ('Curepipe', 2), ('Mahebourg', 2),
('Saint-Denis', 3), ('Saint-Pierre', 3), ('Le Tampon', 3),
('Paris', 4), ('Marseille', 4), ('Lyon', 4);

INSERT INTO trajets (id_depart, id_arrivee) VALUES
(1, 4),   -- Antananarivo -> Port-Louis
(4, 1),   -- Port-Louis -> Antananarivo
(1, 7),   -- Antananarivo -> Saint-Denis
(7, 1),   -- Saint-Denis -> Antananarivo
(1, 10),-- Antananarivo -> Paris
(10, 1),-- Paris -> Antananarivo
(4, 10), -- Port-Louis -> Paris
(10, 4), -- Paris -> Port-Louis
(7, 10), -- Saint-Denis -> Paris
(10, 7), -- Paris -> Saint-Denis
(5, 6),   -- Curepipe -> Mahebourg
(6, 5);   -- Mahebourg -> Curepipe

INSERT INTO frais_trajets (frais, id_type_frais, date_changement, id_trajet) VALUES
(250.00, 1, '2025-01-22', 1), 
(800.00, 2, '2025-01-22', 1),  
(260.00, 1, '2025-01-22', 2), 
(820.00, 2, '2025-01-22', 2),
(300.00, 1, '2025-01-22', 3),  
(900.00, 2, '2025-01-22', 3),
(310.00, 1, '2025-01-22', 4),  
(920.00, 2, '2025-01-22', 4),
(1200.00, 1, '2025-01-22', 5),
(3500.00, 2, '2025-01-22', 5),
(1250.00, 1, '2025-01-22', 6),
(3600.00, 2, '2025-01-22', 6),
(900.00, 1, '2025-01-22', 7),
(2800.00, 2, '2025-01-22', 7),
(920.00, 1, '2025-01-22', 8),
(2900.00, 2, '2025-01-22', 8),
(950.00, 1, '2025-01-22', 9),
(3000.00, 2, '2025-01-22', 9),
(970.00, 1, '2025-01-22', 10),
(3100.00, 2, '2025-01-22', 10),
(200.00, 1, '2025-01-22', 11), 
(700.00, 2, '2025-01-22', 11),
(210.00, 1, '2025-01-22', 12),
(720.00, 2, '2025-01-22', 12);

INSERT INTO config_frais (date_debut, date_fin, pourcentage, id_categorie_age) VALUES
(NULL, NULL, 72.00, 2),
(NULL, NULL, 75.00, 2),
(NULL, NULL, 100.00, 3);

INSERT INTO avions (nom_avion, siege_economique, siege_business) VALUES
('Boeing 737', 150, 20),
('Airbus A320', 160, 24),
('Boeing 777', 250, 40),
('Airbus A330', 270, 36),
('Embraer E190', 100, 12),
('Boeing 787', 240, 32),
('Airbus A350', 280, 40),
('ATR 72', 68, 0),
('Bombardier Q400', 78, 6),
('Boeing 767', 220, 30),
('Airbus A319', 140, 16),
('Comac C919', 158, 20),
('McDonnell Douglas DC-10', 270, 35),
('Boeing 727', 189, 18),
('Sukhoi Superjet 100', 87, 8);

-- Admin
INSERT INTO utilisateurs (nom, prenom, email, mot_de_passe, id_role) VALUES
('Admin', 'Admin', 'admin@gmail.com', 'admin', 1);
-- Utilisateurs
INSERT INTO utilisateurs (nom, prenom, email, mot_de_passe) VALUES
('Rakoto', 'Alain', 'rakoto.alain@gmail.com', 'rakoto'),
('Rafara', 'Patricia', 'rafara.patricia@gmail.com', 'rafara'),
('Fenohasina', 'Eddy', 'fenohasina.eddy@gmail.com', 'fenohasina'),
('Manantsoa', 'Odette', 'manantsoa.odette@gmail.com', 'manantsoa');
