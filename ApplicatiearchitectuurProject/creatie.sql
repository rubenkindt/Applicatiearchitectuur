
DROP TABLE opleiding;
drop table machine;
drop table reserveerbaredagen;
drop table reservatie;
drop table gebruiker;
drop table student;
drop table extern;
drop table docent;

create table opleiding (
onaam varchar(20),
oid int,
PRIMARY KEY(oid)
);

create table machine (
lokaal varchar(20),
omschrijving text,
mnaam varchar(20),
serieNr varchar(20),
huurprijs int,
aankoopprijs int,
oid int,
PRIMARY KEY(serieNr),
FOREIGN KEY (oid) REFERENCES opleiding(oid)
);

create table reserveerbaredagen (
datum date,
serieNr varchar(20),
oid int,
PRIMARY KEY(datum),
FOREIGN KEY (serieNr) REFERENCES machine(serieNr),
FOREIGN KEY (oid) REFERENCES opleiding(oid)
);

create table reservatie (
rid int,
datum date,
serieNr varchar(20),
oid int,
PRIMARY KEY(rid),
FOREIGN KEY (serieNr) REFERENCES machine(serieNr),
FOREIGN KEY (oid) REFERENCES opleiding(oid)
);

create table gebruiker (
gid int,
wachtwoord varchar(30),
gnaam varchar(20),
groep varchar(20),
PRIMARY KEY(gid)
);

create table student (-- aparte tabel voor studenten is makkelijker voor security
gid int,
PRIMARY KEY(gid),
FOREIGN KEY (gid) REFERENCES gebruiker(gid)
);

create table extern (-- aparte tabel voor extern is makkelijker voor security
gid int,
PRIMARY KEY(gid),
FOREIGN KEY (gid) REFERENCES gebruiker(gid)
);

create table docent (-- aparte tabel voor docent is makkelijker voor security
gid int,
oid int,
FOREIGN KEY (gid) REFERENCES gebruiker(gid),
FOREIGN KEY (oid) REFERENCES opleiding(oid)
);

/*insert into opleiding values ('ICT', 4001);
insert into machine values ('k111', "Deze machine draait rond",'MachineNaam','S001-99',20,200000,4001);
insert into reserveerbaredagen values (2019-12-31,'S001-99',4001);
insert into reservatie values (5001,2019-12-30,'S001-99',4001);
insert into gebruiker values (10001,'pAssw','StudentNaam','studenten');
insert into student values (10001);
insert into gebruiker values (20001,'azerty','ExternNaam','externen');
insert into extern values (20001);
insert into gebruiker values (30001,'123wachtW','DocentNaam','docenten');
insert into docent values (30001,4001);
*/
--select * from opleiding;
--select * from machine;
--select * from reserveerbaredagen;
--select * from reservatie;
--select * from gebruiker;
--select * from student;
--select * from extern;
--select * from docent;

