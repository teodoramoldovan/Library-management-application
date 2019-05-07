-- Triggere biblioteca
use biblioteca;

-- ----------------------------------------------------
-- 1.Trigger inserare in istoric dupa restituire carte|
-- ----------------------------------------------------

drop trigger if exists inserare_istoric;

delimiter //
create trigger inserare_istoric after delete on imprumut_curent
for each row begin
	insert into istoric_imprumut(data_returnarii,membru,isbn)
    values (curdate(),old.membru,old.isbn_carte);
end //
delimiter ;

-- ----------------------------------------------------
-- 2.Trigger pentru anunt penalizare la returnare     |
-- ----------------------------------------------------
drop trigger if exists penalizare;

delimiter //
create trigger penalizare after delete on imprumut_curent
for each row begin
	set @tarif=null;
    select carte.tarif_penalizare into @tarif from carte where carte.isbn=old.isbn_carte;
	if ((curdate()-old.data_final)>0) then
		set @message_text=concat('Aveti de platit penalizare: ',(curdate()-old.data_final)*@tarif,' lei');
		signal sqlstate value '45000'
		set message_text=@message_text;
    end if;
end //
delimiter ;

-- ----------------------------------------------------
-- 3.Trigger verificare constrangeri varsta membrii noi |
-- ----------------------------------------------------
drop trigger if exists verificare_membru;
delimiter //
create trigger verificare_membru before insert on membru
for each row begin
	
    if(new.data_nasterii<'1900-01-01'or new.data_nasterii>'2013-01-01') then
		signal sqlstate '45000'
        set message_text='Varsta nu este corespunzatoare pt a deveni membru al bibliotecii';
	end if;
end //
delimiter ;



    