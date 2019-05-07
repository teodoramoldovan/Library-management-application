-- --------------------------------------------------------|
-- Stergerea bazei de date daca exista si crearea acesteia |
-- --------------------------------------------------------|
drop database if exists Biblioteca;

create database if not exists Biblioteca;
use Biblioteca;

-- -------------|
-- Tabel MEMBRU |
-- -------------|

create table if not exists membru
( id_membru int unique not null auto_increment,
nume varchar(40),
prenume varchar(40),
strada varchar(40),
numar int,
oras varchar(40),
ocupatie varchar(40),
data_nasterii date,
sex char(1),
adresa_email varchar(40) unique);

alter table membru
add primary key(id_membru);



-- -------------|
-- Tabel CARTE  |
-- -------------|

create table if not exists carte
(isbn int unique not null,
limba varchar(45),
nr_total_copii int,
nr_copii_disponibile int,
categorie varchar(45),
status varchar(45),
locatie_in_biblioteca varchar(45),
tarif_penalizare double);

alter table carte
add primary key(isbn);

-- ----------------------|
-- Tabel IMPRUMUT_CURENT |
-- ----------------------|

create table if not exists imprumut_curent
(id_imprumut int unique not null auto_increment,
data_inceput date,
data_final date,
membru int ,
ISBN_carte int);

alter table imprumut_curent
add primary key(id_imprumut);

alter table imprumut_curent
add constraint imprumut_curent_fk1 foreign key(membru) references membru(id_membru) on delete no action on update no action;

alter table imprumut_curent
add constraint imprumut_curent_fk2 foreign key(ISBN_carte) references carte(ISBN) on delete no action on update no action;

-- -----------------------|
-- Tabel ISTORIC_IMPRUMUT |
-- -----------------------|
create table if not exists istoric_imprumut
(id_istoric int unique not null auto_increment,
data_returnarii date,
membru int,
isbn int);

alter table istoric_imprumut
add primary key(id_istoric);

alter table istoric_imprumut
add constraint istoric_imprumut_fk1 foreign key(membru) references membru(id_membru) on delete no action on update no action,
add constraint istoric_imprumut_fk2 foreign key(isbn) references carte(isbn) on delete no action on update no action;

-- -----------------------|
-- Tabel REZERVARE_ONLINE |
-- -----------------------|
create table if not exists rezervare_online
(id_rezervare int unique not null auto_increment,
data_inceput date,
data_final date,
membru int,
isbn int);

alter table rezervare_online
add primary key(id_rezervare);

alter table rezervare_online
add constraint rezervare_online_fk1 foreign key(membru) references membru(id_membru) on delete no action on update no action,
add constraint rezervare_online_fk2 foreign key(isbn) references carte(isbn) on delete no action on update no action;




-- -----------------------|
-- Tabel OPERA            |
-- -----------------------|
create table opera
(id_opera int not null unique auto_increment,
titlu varchar(45),
autor varchar(45));

alter table opera
add primary key(id_opera);

-- -----------------------|
-- Tabel TIPARITA         |
-- -----------------------|
create table tiparita
(isbn int not null,
opera int not null,
editura varchar(45));

alter table tiparita
add primary key(isbn,opera),add key(opera);

alter table tiparita
add constraint tiparita_fk1 foreign key(opera) references opera(id_opera) on delete no action on update no action,
add constraint tiparita_fk2 foreign key(isbn) references carte(isbn) on delete no action on update no action;

-- -----------------------|
-- Tabel MANUSCRIS        |
-- -----------------------|
create table manuscris
(isbn int not null,
opera int not null,
anul_scrierii year);

alter table manuscris
add primary key(isbn,opera),add key(opera);

alter table manuscris
add constraint manuscris_fk1 foreign key(opera) references opera(id_opera) on delete no action on update no action,
add constraint manuscris_fk2 foreign key(isbn) references carte(isbn) on delete no action on update no action;




-- -----------------------|
-- Tabel SALA_STUDIU      |
-- -----------------------|
create table if not exists sala_studiu
(nr_sala int unique not null auto_increment,
etaj int,
denumire varchar(45),
nr_total_locuri int,
nr_locuri_disponibile int);

alter table sala_studiu
add primary key(nr_sala);

-- -----------------------|
-- Tabel ANGAJAT          |
-- -----------------------|
create table if not exists angajat
(id_angajat int unique not null auto_increment,
nume varchar(45),
prenume varchar(45),
data_angajarii date);

alter table angajat 
add primary key(id_angajat);

-- -----------------------|
-- Tabel ACCES_SALA       |
-- -----------------------|
create table if not exists acces_sala
(membru int not null,
sala int not null,
angajat_responsabil int not null,
data_acces date);

alter table acces_sala
add primary key(membru,sala,angajat_responsabil),add key(sala),add key(angajat_responsabil);

alter table acces_sala
add constraint acces_fk1 foreign key(membru) references membru(id_membru) on delete no action on update no action,
add constraint acces_fk2 foreign key(sala) references sala_studiu(nr_sala) on delete no action on update no action,
add constraint acces_fk3 foreign key(angajat_responsabil) references angajat(id_angajat) on delete no action on update no action;

-- -----------------------|
-- Tabel EVENIMENTE       |
-- -----------------------|
create table eveniment
(id_event int unique not null auto_increment,
denumire varchar(45),
data_inceput date,
data_final date,
domeniu varchar(45));

alter table eveniment 
add primary key(id_event);

-- ------------------------------------|
-- Tabel PARTICIPARE_EVENIMENT         |
-- ------------------------------------|
create table if not exists participare_eveniment
(id_participare int unique not null auto_increment,
data_participarii date,
membru int,
eveniment int);

alter table participare_eveniment
add primary key(id_participare);

alter table participare_eveniment
add constraint participare_fk1 foreign key(membru) references membru(id_membru),
add constraint participare_fk2 foreign key(eveniment) references eveniment(id_event);



