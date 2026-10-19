# TICKETING

## Aperçu

Ce projet est une application de gestion de tickets d'avion composée de trois modules complémentaires : un mini-framework Java, une API Spring Boot et une couche Express/CDN.

## Environnements

| Composant | Technologie | Version |
|-----------|-------------|---------|
| Mini-framework | Java | 11 |
| API | Spring Boot (Java) | 17 |
| Couche Express/CDN | Node.js | ^18 |
| Base de données | PostgreSQL | ^13 |

## Lancement en local

1. **Démarrer PostgreSQL** sur votre machine.

2. **Exécuter les scripts SQL** dans l'ordre (1 à 4) dans la base de données requise par le mini-framework.

3. **Lancer la couche Express** :
   ```bash
   cd express
   npm run start
   ```

4. **Configurer le projet Spring** :
   - Renseigner le fichier application.properties avec vos paramètres de connexion.

5. **Configurer le mini-framework** :
   - Renseigner le fichier persistence.xml situé dans bin/META-INF.
  
6. **Configurer le fichier de déploiement du mini-framework** :
   - *Windows* : créer un fichier .bat.
   - *Linux* : adapter les chemins dans le script existant.
   
7. **Exécuter le fichier de déploiement du mini-framework.**

8. **Lancer le projet Spring**
   ```bash
   ./mvnw spring-boot:run
   ```
   
