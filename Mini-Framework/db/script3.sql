CREATE OR REPLACE FUNCTION hash_password()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.mot_de_passe IS NOT NULL AND length(NEW.mot_de_passe)<60 THEN
        NEW.mot_de_passe:=crypt(NEW.mot_de_passe, gen_salt('bf'));
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_hash_password
BEFORE INSERT OR UPDATE OF mot_de_passe
ON utilisateurs
FOR EACH ROW
EXECUTE FUNCTION hash_password();


-- VUES
-- Derniers pourcentages fixes 
CREATE OR REPLACE VIEW v_pourcentages_fixes AS
SELECT DISTINCT ON (ca.id_categorie_age) 
    ca.id_categorie_age, ca.nom_categorie_age, cf.pourcentage 
FROM 
    categories_ages ca 
JOIN config_frais cf ON ca.id_categorie_age=cf.id_categorie_age 
WHERE
    cf.date_debut IS NULL AND cf.date_fin IS NULL
ORDER BY ca.id_categorie_age, cf.id_config DESC;

-- Trajets
CREATE OR REPLACE VIEW v_trajets AS
SELECT 
    t.id_trajet, 
    vd.nom_ville as ville_depart, 
    pd.nom_pays as pays_depart, 
    va.nom_ville as ville_arrivee, 
    pa.nom_pays as pays_arrivee
FROM trajets t 
JOIN villes vd ON t.id_depart=vd.id_ville 
JOIN pays pd ON vd.id_pays=pd.id_pays 
JOIN villes va ON t.id_arrivee=va.id_ville 
JOIN pays pa ON va.id_pays=pa.id_pays;

-- Frais par trajet
CREATE OR REPLACE VIEW v_frais AS
SELECT DISTINCT ON (f1.id_trajet, f2.id_trajet) 
    f1.id_trajet, 
    f2.frais AS frais_business,
    (SELECT pourcentage/100 FROM v_pourcentages_fixes
        WHERE id_categorie_age=3
    )*f1.frais AS frais_adulte, 
    (SELECT pourcentage/100 FROM v_pourcentages_fixes
        WHERE id_categorie_age=2
    )*f1.frais AS frais_enfant
FROM 
    frais_trajets f1 
JOIN 
    (SELECT id_trajet, frais FROM frais_trajets WHERE id_type_frais=2) AS f2 
ON f1.id_trajet=f2.id_trajet 
WHERE f1.id_type_frais=1
ORDER BY 
    f1.id_trajet, f2.id_trajet DESC;


-- ALTERS
Alter table vols ADD column is_deleted BOOLEAN NOT NULL DEFAULT FALSE;
