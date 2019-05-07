use Biblioteca;

insert into membru(nume,prenume,strada,numar,oras,ocupatie,data_nasterii,sex,adresa_email) values
('Popescu','Ion','Dorobantilor',20,'Cluj-Napoca','student','1997-03-29','M','popescu.ion@gmail.com'),
('Antonescu','Maria','Balcescu',3,'Cluj-Napoca','pensionar','1941-07-30','F','anotnescu.maria@gmail.com'),
('Duda','Bogdan','Vasile Lupu',17,'Bistrita','student','1998-05-01','M','bogdan.duda@gmail.com'),
('Tulai','Ioana','B.P.Hasdeu',2,'Alba Iulia','student','1997-12-24','F','tulai.ioana@gmail.com'),
('Avram','Lavinia','Soarelui',4,'Zalau','elev','2000-11-01','F','avram.lavinia@gmail.com'),
('Cosma','Razvan','Victor Deleu',23,'Zalau','inginer','1994-04-22','M','cosma.razvan@gmail.com');

insert into carte(isbn,limba,nr_total_copii,nr_copii_disponibile,categorie,status,locatie_in_biblioteca,tarif_penalizare) values
(18903,'Romana',5,5,'SF','Disponibil','Zona Copii',1.5),
(20818,'Romana',1,0,'romantic','Rezervat','Zona Literatura',2),
(26839,'Engleza',2,0,'politist','Imprumutat','Zona Literatura',2),
(38492,'Romana',1,1,'stiinta','Disponibil','Zona Educatie',3.5),
(12732,'Germana',3,2,'religie','Disponibil','Zona Educatie',0.5),
(17492,'Romana',4,4,'biografie','Disponibil','Zona Literatura',1.2);

insert into rezervare_online(data_inceput,data_final,membru,isbn) values
('2017-12-11','2017-12-12',4,18903),
('2017-12-10','2017-12-11',1,17492);

insert into imprumut_curent(data_inceput,data_final,membru,isbn_carte) values
('2017-12-01','2017-12-15',1,12732),
('2017-12-07','2017-12-21',4,26839);

insert into istoric_imprumut(data_returnarii,membru,isbn) values
('2017-11-02',1,38492);

insert into opera(titlu,autor) values
('Harry Potter si piatra filozofala','J.K.Rowling'),
('Suflete pereche','Cecelia Ahern'),
('Murder on the Orient Express','Agatha Christie'),
('Marele plan','Stephen Hawking & Leonard Mlodinov'),
('Offenbarung des Johannes','-'),
('Steve Jobs','Walter Isaacson');

insert into tiparita(isbn,opera,editura) values
('18903','1','Editura Arthur'),
('20818','2','Editura All'),
('26839','3','Editura Rao'),
('38492','4','Editura All');

insert into manuscris(isbn,opera,anul_scrierii) values
('12732','5',1902),
('17492','6',2013);

insert into sala_studiu(etaj,denumire,nr_total_locuri,nr_locuri_disponibile) values
(0,'Referinte',30,21),
(1,'D.D.Rosca',52,51),
(2,'Tudor Dumitru Savu',48,48),
(3,'Victor Babes',45,43),
(4,'Colectii Speciale',12,12),
(4,'Adolescenti',15,10);

insert into angajat(nume,prenume,data_angajarii) values
('Marinescu','Ioan','2003-10-12'),
('Chintoan','Marinela Ioana','2010-05-13'),
('Ifrim','Raluca','2013-01-18'),
('Bucur','Bianca','2012-02-28'),
('Hategan','Doru','2006-12-19');

insert into acces_sala(membru,sala,angajat_responsabil,data_acces) values
(1,2,1,'2017-12-07'),
(2,2,1,'2017-12-07'),
(1,4,3,'2017-12-08'),
(3,4,2,'2017-12-08'),
(6,1,3,'2017-12-11');

insert into eveniment(denumire,data_inceput,data_final,domeniu) values
('Cenaclul literar Traian Brad','2017-12-12','2017-12-13','Literatura Copii'),
('Concert caritabil de craciun','2017-12-08','2017-12-08','Caritate'),
('ShoeBox','2017-12-01','2017-12-23','Caritate'),
('Expozitie Fantezie si Creatie','2017-11-07','2017-12-09','Fotografie');

insert into participare_eveniment(data_participarii,membru,eveniment) values
('2017-12-12',2,1),
('2017-11-14',1,4),
('2017-12-03',1,3),
('2017-12-04',2,4),
('2017-12-08',5,2);

insert into imprumut_curent(data_inceput,data_final,membru,isbn_carte) values
('2017-11-29','2017-12-06',3,20818);