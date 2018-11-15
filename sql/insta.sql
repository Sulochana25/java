select * from InstaUsers

create table GGKUsers(id int identity(1,1) primary key,firstname varchar(30), lastname varchar(30), loginid varchar(20) unique, emailid varchar(40) unique, password varchar(25) )

insert into GGKUsers values('first1', 'last1', '1234','','password')

select * from GGKUsers

create table posted_pictures(userid int foreign key references GGKUsers(id) ,pictureid int identity(25,1) primary key, picdesc varchar(250), dateposted smalldatetime default getdate(),pictureview int, pictureblob varbinary(max))

insert into posted_pictures(userid,picdesc,pictureview,pictureblob) select 1,'first pic', 0, * from openrowset (bulk N'C:\Users\sulochana.dhal\Desktop\ggk.png',single_blob) as pictureblob 

insert into posted_pictures(userid,picdesc,pictureview,pictureblob) values(2,'first pic', 0,convert(varbinary(max),'C:\Users\sulochana.dhal\Desktop\ggk.png' ))

select * from posted_pictures

drop table posted_pictures

select pictureblob from posted_pictures where userid=1
