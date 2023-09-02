create table notas(
       id bigint not null auto_increment,
       cnpj varchar(14) not null,
       tomador varchar(100) not null,
       numero int not null,
       chave varchar(44) not null,
       emissao varchar(10),
       valor double not null,

       primary key(id)

)