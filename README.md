# CVenLigne
=====
1. Cloner le projet en utilisant la commande git clone https://github.com/Bombounet/CVenLigne

2. Importer le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce repository.

3. Exécuter votre DB mysql dans le dossier ".../CVenLigne". Si vous avez docker, vous pouvez utiliser la commande suivante:
```docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb```

4. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.

5. Dans Application.properties et LibraryControler changer l'url en haut de page en fonction de votre distribution (localhost & 192.168.99.100)

6. Dans IntelliJ IDEA et cliquez sur run "Application" ou MAJ+F10

7. Ouvrir l'URL "http://localhost:8080/"

=====
DESCRIPTION DES PAGES

Le site est divisé en 6 pages et chacune sont editables par l'utlisateur

Toutes les pages possèdent :  
	- la barre de navigation en haut dont chaque element est cliquable et renvoie sur la page dédiée
	- le pied de page avec les liens vers les réseaux sociaux et la page contact
	
la page d'accueil possède : 
	- la section titre avec l'accroche
	- la section "à propos" avec les détails de l'utilisateur
	- la section "mon parcours" avec un tableau récapitulatif dont les images sont cliquables et renvoient sur la page dédiée
	
les pages contact, compétences, expérience, formation et projet ont : 
	- une unique section de description des details

=====
CHOIX GRAPHIQUES

Nous avons choisi un thème :  
	- sobre
	- sombre
	- aéré 
Cela permet à un CV d'être efficace, lisible et de se démarquer des autres.



PS : Commande gitk non recommandé :)
