INSERT INTO defaultdb.adresse (id, adress, city, country, postcode) VALUES (1, '9 avenue galigny', 'sceaux', 'france',93330);
INSERT INTO defaultdb.competences (id, competence) VALUES (1, 'anglais courant');
INSERT INTO defaultdb.competences (id, competence) VALUES (2, 'espagnol courant');
INSERT INTO defaultdb.competences (id, competence) VALUES (3, 'allemand courant');
INSERT INTO defaultdb.competences (id, competence) VALUES (4, 'italien courant');
INSERT INTO defaultdb.competences (id, competence) VALUES (5, 'java courant');
INSERT INTO defaultdb.formations (id, name, place, description, year, user_id) VALUES (1, 'EPF', 'SCEAUX','formation ingenieurie numérique', '2015-2020', 1);
INSERT INTO defaultdb.experiences (id, name, place, description, year, user_id) VALUES (1, 'Stage 4A Eleve Ingenieur', 'USA', 'coding for WolksWagen', '2019', 1);
INSERT INTO defaultdb.projets (id, name, place, description, year, user_id) VALUES (1, 'projet java 2A', 'EPF', 'coding a copy of binding of isaac named binding of the peuf', '2019', 1);
INSERT INTO defaultdb.users (id, first_name, last_name, birth_day, birth_month, birth_year, phone_number, email, bio, adress, city, country, postcode)
VALUES (1, 'Marion', 'Delort', 23, 12, 1997, 610798624, 'marion.delort@epfedu.fr', 'eleve ingenieure en 5 eme annee recherche un stage eleve ingenieur dans le domainbe de l''informatique', '9 avenue galigny', 'sceaux', 'france', 93330);
INSERT INTO defaultdb.users_competences (id, user_id, competences_id) VALUES (1, 1, 1);
INSERT INTO defaultdb.users_competences (id, user_id, competences_id) VALUES (2, 1, 2);
INSERT INTO defaultdb.users_competences (id, user_id, competences_id) VALUES (3, 1, 3);
INSERT INTO defaultdb.users_competences (id, user_id, competences_id) VALUES (4, 1, 4);
INSERT INTO defaultdb.users_competences (id, user_id, competences_id) VALUES (5, 1, 5);