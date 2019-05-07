use biblioteca;

-- Aflati in ce sala de studiu sunt disponibile peste 20 de locuri.

drop view if exists locuri_in_sala;

create view locuri_in_sala as
select denumire as 'Denumire sala', nr_locuri_disponibile as 'Locuri disponibile'
from sala_studiu
where nr_locuri_disponibile>20;

-- Numarul de evenimente care incep in luna decembrie.

drop view if exists evenimente_decembrie;

create view evenimente_decembrie as
select distinct count(id_event) as 'Numar evenimente'
from eveniment
where month(data_inceput)=12;

-- Cartile tiparite in limba romana.

drop view  if exists tiparite_rom;

create view tiparite_rom as
select titlu as 'Carti tiparite in limba romana'
from carte,tiparita,opera
where carte.isbn=tiparita.isbn and opera.id_opera=tiparita.opera and carte.limba='Romana';


-- Toate informatiile despre carti
drop view if exists Carti;
create view Carti as 
select carte.isbn,opera.titlu,opera.autor,carte.categorie,carte.status,carte.locatie_in_biblioteca,carte.tarif_penalizare
from carte,opera,tiparita
where carte.isbn=tiparita.isbn and tiparita.opera=opera.id_opera
group by opera.titlu
union
select carte.isbn,opera.titlu,opera.autor,carte.categorie,carte.status,carte.locatie_in_biblioteca,carte.tarif_penalizare
from carte,opera,manuscris
where carte.isbn=manuscris.isbn and manuscris.opera=opera.id_opera
group by opera.titlu asc;

-- Informatii imprumuturi
drop view if exists Imprumuturi;
create view Imprumuturi as
select imprumut_curent.id_imprumut,imprumut_curent.data_inceput,imprumut_curent.data_final,membru.nume,membru.prenume,opera.titlu,opera.autor
from imprumut_curent,membru,carte,opera,tiparita
where imprumut_curent.membru=membru.id_membru and imprumut_curent.ISBN_carte=carte.isbn and carte.isbn=tiparita.isbn and tiparita.opera=opera.id_opera
group by membru.nume asc
union
select imprumut_curent.id_imprumut,imprumut_curent.data_inceput,imprumut_curent.data_final,membru.nume,membru.prenume,opera.titlu,opera.autor
from imprumut_curent,membru,carte,opera,manuscris
where imprumut_curent.membru=membru.id_membru and imprumut_curent.ISBN_carte=carte.isbn and carte.isbn=manuscris.isbn and manuscris.opera=opera.id_opera
order by membru.nume asc;

-- Informatii rezervari
drop view if exists Rezervari;
create view Rezervari as
select rezervare_online.id_rezervare,rezervare_online.data_inceput,rezervare_online.data_final,membru.nume,membru.prenume,opera.titlu,opera.autor
from rezervare_online,membru,carte,opera,tiparita
where rezervare_online.membru=membru.id_membru and rezervare_online.ISBN=carte.isbn and carte.isbn=tiparita.isbn and tiparita.opera=opera.id_opera
group by membru.nume asc
union
select rezervare_online.id_rezervare,rezervare_online.data_inceput,rezervare_online.data_final,membru.nume,membru.prenume,opera.titlu,opera.autor
from rezervare_online,membru,carte,opera,manuscris
where rezervare_online.membru=membru.id_membru and rezervare_online.ISBN=carte.isbn and carte.isbn=manuscris.isbn and manuscris.opera=opera.id_opera
group by membru.nume asc; 

-- Informatii istoric imprumuturi
drop view if exists Istoric;
create view Istoric as
select istoric_imprumut.id_istoric,istoric_imprumut.data_returnarii,membru.nume,membru.prenume,opera.titlu,opera.autor
from istoric_imprumut,membru,carte,opera,tiparita
where istoric_imprumut.membru=membru.id_membru and istoric_imprumut.ISBN=carte.isbn and carte.isbn=tiparita.isbn and tiparita.opera=opera.id_opera
group by istoric_imprumut.id_istoric asc
union
select istoric_imprumut.id_istoric,istoric_imprumut.data_returnarii,membru.nume,membru.prenume,opera.titlu,opera.autor
from istoric_imprumut,membru,carte,opera,manuscris
where istoric_imprumut.membru=membru.id_membru and istoric_imprumut.ISBN=carte.isbn and carte.isbn=manuscris.isbn and manuscris.opera=opera.id_opera
group by istoric_imprumut.id_istoric asc; 

-- ADAUGATE DUPA PUS PE DRIVE
-- Informatii tiparite
drop view if exists Informatii_tiparite;
create view Informatii_tiparite as
select opera.titlu,opera.autor,carte.limba,carte.nr_total_copii,carte.nr_copii_disponibile,carte.categorie,carte.locatie_in_biblioteca,carte.tarif_penalizare,tiparita.editura
from carte,opera,tiparita
where carte.isbn=tiparita.isbn and tiparita.opera=opera.id_opera
group by opera.titlu;


-- Informatii manuscrise
drop view if exists Informatii_manuscrise;
create view Informatii_manuscrise as
select opera.titlu,opera.autor,carte.limba,carte.nr_total_copii,carte.nr_copii_disponibile,carte.categorie,carte.locatie_in_biblioteca,carte.tarif_penalizare,manuscris.anul_scrierii
from carte,opera,manuscris
where carte.isbn=manuscris.isbn and manuscris.opera=opera.id_opera
group by opera.titlu;



-- Informatii membrii

drop view if exists Informatii_membrii;
create view Informatii_membrii as
select id_membru,nume,prenume,ocupatie,adresa_email
from membru
group by id_membru;

-- Informatii acces
drop view if exists Informatii_acces;
create view Informatii_acces as
select membru.nume as Nume_Membru,membru.prenume as Prenume_Membru,acces_sala.sala,angajat.nume as Nume_angajat,angajat.prenume as Prenume_angajat,acces_sala.data_acces
from membru,acces_sala,angajat
where membru.id_membru=acces_sala.membru and angajat.id_angajat=acces_sala.angajat_responsabil
order by acces_sala.data_acces asc;