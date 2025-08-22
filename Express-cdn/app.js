const express = require("express");
const cors = require("cors");
require('dotenv').config();

const app = express();

// Lire la liste des origines depuis la variable d’environnement et créer un tableau
const allowedOrigins = process.env.APP_ORIGINS ? process.env.APP_ORIGINS.split(',') : [];

// Configurer CORS avec vérification dynamique de l’origine
const corsOptions = {
  origin: function(origin, callback) {
    // Autoriser les requêtes sans origine (ex : Postman, curl)
    if (!origin) return callback(null, true);

    if (allowedOrigins.indexOf(origin) !== -1) {
      callback(null, true);
    } else {
      callback(new Error("Not allowed by CORS"));
    }
  }
};

app.use(cors(corsOptions));
app.use(express.json());

app.use(express.static("public"));
app.use(express.urlencoded({ extended: true }));

// Démarrer le serveur
const PORT = process.env.APP_PORT || 3000;
app.listen(PORT, () => {
  console.log(`Serveur démarré sur http://localhost:${PORT}`);
});
