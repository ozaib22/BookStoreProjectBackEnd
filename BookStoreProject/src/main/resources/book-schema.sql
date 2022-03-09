drop table if exists book CASCADE;
 create table book (book_id integer generated AUTO_INCREMENT, name varchar(255) not null, price integer, publish_date integer, primary key (book_id));