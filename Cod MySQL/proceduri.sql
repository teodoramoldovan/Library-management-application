-- Proceduri Biblioteca
use Biblioteca;

-- ----------------------
-- 1.Adaugare membru nou|
-- ----------------------


drop procedure if exists adaugare_membru_nou;

delimiter //
create procedure adaugare_membru_nou(nume varchar(40),prenume varchar(40),strada varchar(40),numar int,oras varchar(40),ocupatie varchar(40),data_nasterii date,sex char(1),adresa_email varchar(40))
begin
	start transaction;
		set @email=null;
        select @email:=membru.adresa_email from membru where membru.adresa_email=adresa_email;
        if((@email is null) and (nume is not NULL) and (prenume is not NULL) and (strada is not NULL) and (numar is not NULL) and (oras is not NULL) and (ocupatie is not NULL) and (data_nasterii is not NULL) and (sex is not NULL) and (adresa_email is not NULL)) then
        begin
			insert into membru(nume,prenume,strada,numar,oras,ocupatie,data_nasterii,sex,adresa_email) values
            (nume,prenume,strada,numar,oras,ocupatie,data_nasterii,sex,adresa_email);
            commit;
            end;
		else rollback;
		end if;
	end //
    
delimiter ;

call adaugare_membru_nou('Nas','Razvan','Jiului',2,'Cluj-Napoca','student','1998-01-31','M','nas.razvan@gmail.com');
call adaugare_membru_nou('Naum','Iuliu','Eroilor',173,'Floresti','student','1997-04-20','M','naum.iuliu@gmail.com');
call adaugare_membru_nou(null,null,null,null,null,null,null,null,null);
call adaugare_membru_nou('Puscas','Iulia','Mehedinti',54,'Cluj-Napoca','student','1997-11-03','F','puscasc.iulia@gmail.com');
call adaugare_membru_nou('Puscas','Maria','Viilor',54,'Cluj-Napoca','student','2014-11-03','F','puscas.maria@gmail.com');
call adaugare_membru_nou('Stan','Vasile','Motilor',7,'Cluj-Napoca','student','1998-01-28','M','stan.vasi@gmail.com');

-- ----------------------
-- 2.Adaugare imprumut nou|
-- ----------------------

drop procedure if exists adaugare_imprumut_nou;

delimiter //
create procedure adaugare_imprumut_nou(membru int,isbn int)
begin 
	start transaction;
		set @id_membru=null;
        select @id_membru:=membru.id_membru from membru where membru.id_membru=membru;
        if(@id_membru is not null) then
		begin 
			set @isbn_c=null;
            select @isbn_c:=carte.isbn from carte where carte.isbn=isbn;
            if(@isbn_c is not null) then 
            begin
				set @deja_imprumutat=null;
                select @deja_imprumutat:=carte.status from carte where carte.isbn=isbn;
                if(@deja_imprumutat='Disponibil') then 
                begin
					insert into imprumut_curent(data_inceput,data_final,membru,isbn_carte) values
                    (curdate(),curdate()+14,membru,isbn);
					##scadem numarul de copii disponibile
                    update carte set nr_copii_disponibile=nr_copii_disponibile-1 where carte.isbn=isbn;
                    set @nr_c=null;
                    select @nr_c:=carte.nr_copii_disponibile from carte where carte.isbn=isbn;
                    if(@nr_c=0) then
                    begin
						update carte set status='Imprumutat' where carte.isbn=isbn;
						commit;
                        end;
                    end if;
                    commit;
                    end;
				else rollback;
                end if;
                commit;
                end;
			else rollback;
            end if;
            commit;
            end;
		else rollback;
        end if;
	end //
delimiter ;
call adaugare_imprumut_nou(1,38492);
call adaugare_imprumut_nou(7,13567);
call adaugare_imprumut_nou(null,null);
call adaugare_imprumut_nou(3,17492);

-- ----------------------
-- 3.Restituire imprumut |
-- ----------------------

drop procedure if exists restituire_imprumut;

delimiter //
create procedure restituire_imprumut(membru int,id_imprumut int)
begin 
	start transaction;
		set @id_membru=null;
        select @id_membru:=membru.id_membru from membru where membru.id_membru=membru;
        if(@id_membru is not null) then
		begin 
			set @imprumut=null;
			select @imprumut:=imprumut_curent.id_imprumut from imprumut_curent where imprumut_curent.id_imprumut=id_imprumut;
			if(@imprumut is not null) then
            begin
				set @isbn=null;
				select @isbn:=isbn_carte from imprumut_curent where imprumut_curent.id_imprumut=id_imprumut;
				delete from imprumut_curent where imprumut_curent.id_imprumut=id_imprumut;
					##crestem numarul de copii disponibile 
                    update carte set nr_copii_disponibile=nr_copii_disponibile+1 where carte.isbn=@isbn;
                    #actualizam disponibilitatea cartiie
                    set @nr_c=null;
                    select @nr_c:=carte.nr_copii_disponibile from carte where carte.isbn=@isbn;
                    if(@nr_c>0) then
                    begin
						update carte set status='Disponibil' where carte.isbn=@isbn;
						commit;
                        end;
                    end if;
					commit;
                    end;
				else rollback;
                end if;
                commit;
                end;
			else rollback;
            end if;
            
	end //
delimiter ;


		
call restituire_imprumut(3,5);
call restituire_imprumut(1,4);
call restituire_imprumut(3,3);

-- -------------------------
-- 4.Adaugare rezervare noua|
-- --------------------------

drop procedure if exists adaugare_rezervare_noua;

delimiter //
create procedure adaugare_rezervare_noua(membru int,isbn int)
begin 
	start transaction;
		set @id_membru=null;
        select @id_membru:=membru.id_membru from membru where membru.id_membru=membru;
        if(@id_membru is not null) then
		begin 
			set @isbn_c=null;
            select @isbn_c:=carte.isbn from carte where carte.isbn=isbn;
            if(@isbn_c is not null) then 
            begin
				set @deja_imprumutat=null;
                select @deja_imprumutat:=carte.status from carte where carte.isbn=isbn;
                if(@deja_imprumutat='Disponibil') then 
                begin
					insert into rezervare_online(data_inceput,data_final,membru,isbn) values
                    (curdate(),curdate()+1,membru,isbn);
					##scadem numarul de copii disponibile
                    update carte set nr_copii_disponibile=nr_copii_disponibile-1 where carte.isbn=isbn;
                    set @nr_c=null;
                    select @nr_c:=carte.nr_copii_disponibile from carte where carte.isbn=isbn;
                    if(@nr_c=0) then
                    begin
						update carte set status='Rezervat' where carte.isbn=isbn;
						commit;
                        end;
                    end if;
                    commit;
                    end;
				else rollback;
                end if;
                commit;
                end;
			else rollback;
            end if;
            commit;
            end;
		else rollback;
        end if;
	end //
delimiter ;

call adaugare_rezervare_noua(9,12732);
call adaugare_rezervare_noua(8,12732);


-- ----------------------------
-- 5.Anulare rezervare online |
-- ----------------------------

drop procedure if exists anulare_rezervare;

delimiter //
create procedure anulare_rezervare(membru int,id_rezervare int)
begin 
	start transaction;
		set @id_membru=null;
        select @id_membru:=membru.id_membru from membru where membru.id_membru=membru;
        if(@id_membru is not null) then
		begin 
			set @rezervare=null;
			select @rezervare:=rezervare_online.id_rezervare from rezervare_online where rezervare_online.id_rezervare=id_rezervare;
			if(@rezervare is not null) then
            begin
				set @isbn=null;
				select @isbn:=isbn from rezervare_online where rezervare_online.id_rezervare=id_rezervare;
				delete from rezervare_online where rezervare_online.id_rezervare=id_rezervare;
					##crestem numarul de copii disponibile 
                    update carte set nr_copii_disponibile=nr_copii_disponibile+1 where carte.isbn=@isbn;
                    #actualizam disponibilitatea cartiie
                    set @nr_c=null;
                    select @nr_c:=carte.nr_copii_disponibile from carte where carte.isbn=@isbn;
                    if(@nr_c>0) then
                    begin
						update carte set status='Disponibil' where carte.isbn=@isbn;
						commit;
                        end;
                    end if;
					commit;
                    end;
				else rollback;
                end if;
                commit;
                end;
			else rollback;
            end if;
            
	end //
delimiter ;


call anulare_rezervare(9,3);
call anulare_rezervare(8,4);

-- -------------------------
-- 6.Adaugare opera noua   |
-- -------------------------
drop procedure if exists adaugare_opera;

delimiter //
create procedure adaugare_opera(titlu varchar(45),autor varchar(45))
begin
	start transaction;
    set @title=null;
    select @title:=opera.titlu from opera where opera.autor=autor;
    if(@title<>titlu || @title is null and titlu is not null and autor is not null) then
    begin
		insert into opera(titlu,autor) values
        (titlu,autor);
        commit;
        end;
	else rollback;
	end if;
end //
delimiter ;

call adaugare_opera('An abundance of Katherines','John Green');
call adaugare_opera('Harry Potter si camera secretelor','J.K.Rowling');
call adaugare_opera('Dexter in the dark','Jeff Lindsay');
call adaugare_opera(null,null);


-- ----------------------------
-- 7.Adaugare tiparita noua   |
-- ----------------------------


drop procedure if exists adaugare_tiparita;

delimiter //
create procedure adaugare_tiparita(isbn int ,limba varchar(40),nr_total_copii int ,nr_copii_disponibile int ,categorie varchar(40),status varchar(40),locatie_in_biblioteca varchar(40),tarif_penalizare double,opera int,editura varchar(45))
begin
	start transaction;
		set @carte=null;
        select @carte:=isbn from carte where carte.isbn=isbn;
        if(@carte is null ) then
        begin
			set @opera=null;
            select @opera:=id_opera from opera where opera.id_opera=opera;
            if(@opera is not null) then
            begin 
				insert into carte(isbn,limba,nr_total_copii,nr_copii_disponibile,categorie,status,locatie_in_biblioteca,tarif_penalizare) values
                (isbn,limba,nr_total_copii,nr_copii_disponibile,categorie,status,locatie_in_biblioteca,tarif_penalizare);
                
                insert into tiparita(isbn,opera,editura) values
                (isbn,opera,editura);
				commit;
                end;
			else rollback;
			end if;
			commit;
			end;
		else rollback;
        end if;
end //
delimiter ;

call adaugare_tiparita(45903,'Engleza',1,1,'politist','Disponibil','Zona Literatura',1.1,9,'Editura Rao');

-- ----------------------------
-- 8.Adaugare manuscris nou  |
-- ----------------------------


drop procedure if exists adaugare_manuscris;

delimiter //
create procedure adaugare_manuscris(isbn int ,limba varchar(40),nr_total_copii int ,nr_copii_disponibile int ,categorie varchar(40),status varchar(40),locatie_in_biblioteca varchar(40),tarif_penalizare double,opera int,anul year)
begin
	start transaction;
		set @carte=null;
        select @carte:=isbn from carte where carte.isbn=isbn;
        if(@carte is null ) then
        begin
			set @opera=null;
            select @opera:=id_opera from opera where opera.id_opera=opera;
            if(@opera is not null) then
            begin 
				insert into carte(isbn,limba,nr_total_copii,nr_copii_disponibile,categorie,status,locatie_in_biblioteca,tarif_penalizare) values
                (isbn,limba,nr_total_copii,nr_copii_disponibile,categorie,status,locatie_in_biblioteca,tarif_penalizare);
                
                insert into manuscris(isbn,opera,anul_scrierii) values
                (isbn,opera,anul);
				commit;
                end;
			else rollback;
			end if;
			commit;
			end;
		else rollback;
        end if;
end //
delimiter ;
call adaugare_manuscris(98452,'Engleza',1,1,'romantic','Disponibil','Zona Literatura',1,7,2017);

-- -------------------------------------
-- 9.Adaugare membru in sala de studiu |
-- -------------------------------------
drop procedure if exists adaugare_acces;

delimiter //
create procedure adaugare_acces(membru int,sala int ,angajat int)
begin 
	start transaction;
    set @id_membru=null;
    select @id_membru:=membru.id_membru from membru where membru.id_membru=membru;
    set @id_sala=null;
    select @id_sala:=sala_studiu.nr_sala from sala_studiu where sala_studiu.nr_sala=sala;
    set @id_angajat=null;
    select @id_angajat:=angajat.id_angajat from angajat where angajat.id_angajat=angajat;
    if(@id_membru is not null and @id_sala is not null and @id_angajat is not null) then
    begin
		insert into acces_sala(membru,sala,angajat_responsabil,data_acces) values
        (membru,sala,angajat,curdate());
		commit;
        end;
	else rollback;
	end if;
end //
delimiter ;

call adaugare_acces(7,6,5);