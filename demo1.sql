create database Product ; # Tạo một database
use Product ;#Sử dụng database
drop table if exists InfoProduct ;# Check xem bảng đã tồn tại hay chưa 
drop table if exists InfoStore ;
drop table if exists TypeProduct;
create table TypeProduct ( #Tạo bảng
idType int auto_increment primary key ,
nameTyoe varchar (30)
);
# Thêm các thuộc tính và các ràng buộc (constraints) 
create table InfoStore ( 
nameStore varchar (30) unique primary key
);
create table InfoProduct (
id int auto_increment primary key ,
nameP varchar (30) not null,
price double default 5 ,
idType int ,
nameStore varchar (30),
foreign key (idType) references TypeProduct (idType ), 
foreign key (nameStore) references InfoStore (nameStore)
);
insert into TypeProduct (idType , nameTyoe ) values # Thêm data và bảng 
(1, "Bánh"),
(2, "Kẹo"),
(3, "Nước");
insert into InfoStore (nameStore ) values
("Cửa hàng 1"),
("Cửa hàng 2"),
("Cửa hàng 3") ;
insert into InfoProduct (id , nameP , price , idType , nameStore ) values 
(1 , "Bánh oreo" , 12.200 , 1 , "Cửa hàng 1"),
(2 , "Kẹo dâu" , 3200 , 2 , "Cửa hàng 2" ) ,
(3, "Sting dâu" , 12.000 , 3 , "Cửa hàng 3" ) ;
alter table TypeProduct rename column nameTyoe to nameType ; # Đỏi tên
alter table InfoProduct rename column id to idProduct ; 
alter table InfoProduct rename column nameP to nameProduct ;
alter table InfoStore modify column nameStore varchar (40) not null ; # Đổi kiểu dữ liệu và ràng buộc 
alter table InfoProduct add column codeProduct varchar (30) not null  ; # Thêm thuộc tính 
update InfoProduct 
set codeProduct = "SP1" where idProduct = 1 ; # set data 
update InfoProduct
set codeProduct = "SP2" where idProduct = 2 ;
update InfoProduct
set codeProduct = "SP3" where idProduct = 3 ;
set sql_safe_updates = 0 ; # Vô hiệu hoá chế độ safe mode (an toàn trước khi xoá và sửa )
delete from InfoProduct where codeProduct = "SP2" ;
set sql_safe_updates = 1 ; # Bật safe mode


 
 



