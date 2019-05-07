use Biblioteca;

-- 1. Aflati numarul fetelor inscrise la bibilioteca
select count(*) from membru where sex='F';

-- 2.Aflati anul celui mai vechi manuscris
select min(manuscris.anul_scrierii) as 'Anul manuscris vechi'
from manuscris,carte,opera
where opera.id_opera=manuscris.opera and carte.isbn=manuscris.isbn;

-- 3.Titlu cartilor din Zona de literatura
select distinct opera.titlu 
from opera,tiparita,manuscris,carte
where (opera.id_opera=tiparita.opera  and carte.isbn=tiparita.isbn and locatie_in_biblioteca='Zona literatura') 
or (carte.isbn=manuscris.isbn and opera.id_opera=manuscris.opera and locatie_in_biblioteca='Zona literatura');

-- 4.Aflati numarul de carti tiparite care sunt disponibile
select count(carte.isbn) 
from carte,tiparita
where carte.isbn=tiparita.isbn and carte.status='Disponibil';

-- 5.Numarul membrilor care au rezervare de la data de 09.12.2017 pana la data 13.12.2017
select count(membru.nume)
from membru,rezervare_online
where membru.id_membru=rezervare_online.membru and data_inceput>='2017-12-09' and data_final<='2017-12-13';

-- 6.Lista membrilor care participa la evenimentul ShoeBox in data 04.12.2017
select nume,prenume
from membru,eveniment,participare_eveniment
where membru.id_membru=participare_eveniment.membru and participare_eveniment.data_participarii='2017-12-04' and eveniment.denumire='ShoeBox';

-- 7.Lista id-urilor membrilor care au facut a rezervari online 
select membru.id_membru 
from membru,rezervare_online
where membru.id_membru=rezervare_online.membru;

-- 8.ISBN-ul cartilor restante pana la data curenta,nr de zile restante si tariful de penalizare
select carte.isbn,(curdate()-imprumut_curent.data_final) as 'Zile restante' ,((curdate()-imprumut_curent.data_final)*carte.tarif_penalizare) as 'Penalizare'
from carte,imprumut_curent,istoric_imprumut
where carte.isbn=imprumut_curent.isbn_carte and curdate()>=imprumut_curent.data_final  and carte.isbn not in (select istoric_imprumut.isbn from istoric_imprumut);

-- 9.Numele si prenumele membrilor carora li s-a permis accesul la sala de catre angajatul Ifrim Raluca
select membru.nume,membru.prenume
from membru,acces_sala,angajat
where membru.id_membru=acces_sala.membru and acces_sala.angajat_responsabil=angajat.id_angajat and angajat.nume='Ifrim' and angajat.prenume='Raluca';

-- 10.Lista denumirilor salilor de studiu ordonate alfabetic
select sala_studiu.denumire
from sala_studiu
order by sala_studiu.denumire asc;

-- 11.Aflati numele angajatiilor si numele membriilor care au avut acces la sala Victor Babes
select angajat.nume as 'Nume angajat',angajat.prenume as 'Prenume angajat',membru.nume as 'Nume membru',membru.prenume as 'Prenume membru'
from angajat,acces_sala,membru,sala_studiu
where angajat.id_angajat=acces_sala.angajat_responsabil and membru.id_membru=acces_sala.membru and sala_studiu.nr_sala=acces_sala.sala
and sala_studiu.denumire='Victor Babes';

-- 12.Lista membrilor ordonati dupa varsta
select nume,prenume,(year(curdate())-year(membru.data_nasterii)) as 'Varsta'
from membru
order by (year(curdate())-year(membru.data_nasterii)) asc;

-- 13. Numele si numarul de carti din fiecare zona
select carte.locatie_in_biblioteca,count(isbn) as 'Numar carti'
from carte
group by locatie_in_biblioteca;

-- 14.Titlu cartiilor care se gasesc in cel putin doua exemplare
select distinct opera.titlu 
from opera,tiparita,manuscris,carte
where (opera.id_opera=tiparita.opera  and carte.isbn=tiparita.isbn and nr_copii>=2) 
or (carte.isbn=manuscris.isbn and opera.id_opera=manuscris.opera and nr_copii>=2);

-- 15.Lista numelor membriilor care au participat la mai mult de un eveniment
select membru.nume,membru.prenume 
from membru,participare_eveniment
where membru.id_membru=participare_eveniment.membru group by participare_eveniment.membru having count(participare_eveniment.membru)>1;

-- 16.Aflati numele membrilor care au imprumutat aceeasi carte
select membru.nume
from membru
where membru.id_membru in (select istoric_imprumut.membru from istoric_imprumut where istoric_imprumut.isbn in(select carte.isbn from carte));