drop table customer;
drop table transaction;
Create table customer(customer_id int, customer_name varchar2(50) );
Create table transaction(transaction_id int, customer_id int,transaction_date timestamp,amount int);
insert into customer(customer_id, customer_name) values (1001,'Customer1');
insert into customer(customer_id, customer_name) values (1002,'Customer2');
insert into customer(customer_id, customer_name) values (1003,'Customer3');
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10001,1001,'2022-10-12',120);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10002,1001,'2022-09-01',85);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10003,1001,'2022-09-04',160);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10004,1001,'2022-09-01',90);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10005,1001,'2022-08-04',120);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10006,1001,'2022-08-05',165);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10007,1002,'2022-10-05',113);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10008,1002,'2022-10-27',80);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10009,1002,'2022-09-04',102);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10010,1002,'2022-08-01',210);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10011,1002,'2022-08-27',130);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10012,1002,'2022-08-15',88);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10013,1003,'2022-10-15',102);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10014,1003,'2022-10-27',84);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10015,1003,'2022-10-04',200);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10016,1003,'2022-09-01',103);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10017,1003,'2022-09-27',500);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10018,1003,'2022-08-20',585);
insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10019,1003,'2022-08-14',102);

												