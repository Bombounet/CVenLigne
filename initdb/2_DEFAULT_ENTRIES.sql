-- USER
INSERT INTO defaultdb.users (id, first_name, last_name, birth_day, birth_month, birth_year, phone_number, email, bio, address, city, country, postcode)
VALUES (1, 'Marion', 'Delort', 26, 12, 1997, 695255000, 'marion.delort@epfedu.fr',
'Mes bases d''ingenieure generaliste, scientifique et technologique associees a mes realisations en informatique me confortent dans mon projet de travailler dans l''ingenierie numerique. Je cherche un stage de 6 mois en ingenierie numerique pour concretiser mon projet de fin d''etude.',
'9 avenue de la Lune', 'GENTILLY', 'France', 94250);
-- COMPETENCES
INSERT INTO defaultdb.competences (id, name, user_id) VALUES (1, 'anglais : niveau B2', 1);
INSERT INTO defaultdb.competences (id, name, user_id) VALUES (2, 'francais : langue maternelle',1);
INSERT INTO defaultdb.competences (id, name, user_id) VALUES (3, 'allemand : niveau B1',1);
INSERT INTO defaultdb.competences (id, name, user_id) VALUES (4, 'C, Java, Python, Html, Css, Arduino, Xml, Git',1);
INSERT INTO defaultdb.competences (id, name, user_id) VALUES (5, 'Catia V5',1);
-- FORMATIONS
INSERT INTO defaultdb.formations (id, name, place, description, year, user_id)
VALUES (1, 'Diplome d''ingenieure ', 'EPF ~ Sceaux, France',
'Majeure Ingenierie & Numerique. Specialites : Intelligence Artificielle, Internet Of Things, Conseil & Audit', '2015-2020', 1);
INSERT INTO defaultdb.formations (id, name, place, description, year, user_id)
VALUES (2, 'Baccalaureat scientifique', 'Lycee Descartes ~ Antony, France',
'Specialites : scientifique, sciences du numerique et classe d''allemand avance. Mention bien', '2014 - 2015', 1);
-- EXPERIENCES
INSERT INTO defaultdb.experiences (id, name, place, description, year, user_id)
VALUES (1, 'Stage 6 mois : Test Engineer Intern', 'Volkswagen Group of America ~ Belmont, Californie, USA',
'Tests de prequalification des systèmes d''info-divertissements embarques des voitures Bentley', 'Juillet - Decembre 2018', 1);
INSERT INTO defaultdb.experiences (id, name, place, description, year, user_id)
VALUES (2, 'Membre Associatif : Vice-Presidente BDA', 'EPF, Sceaux',
'Vice-presidente de l''association artistique de l''EPF', '2016 - 2017', 1);
INSERT INTO defaultdb.experiences (id, name, place, description, year, user_id)
VALUES (3, 'Membre Associatif : Responsable Communication ESN', 'EPF, Sceaux',
'Pôle communication de l''association dediee a l''accueil des etudiants etrangers', '2015 - 2016', 1);
-- PROJETS
INSERT INTO defaultdb.projets (id, name, place, description, year, user_id)
VALUES (1, 'Programmation d''une application Android', 'EPF ~ Sceaux, France',
'Programmation d''une application d''aide a la composition de partitions musicales', 'Mars - Juin 2019 ', 1);
INSERT INTO defaultdb.projets (id, name, place, description, year, user_id)
VALUES (2, 'Programmation d''une interface Client-Fournisseur', 'EPF ~ Sceaux, France',
'Programmation d''une interface de reservation de VTC', 'Janvier - Juin 2019 ', 1);

