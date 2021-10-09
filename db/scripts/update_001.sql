update DATABASECHANGELOGLOCK set LOCKED=false, LOCKGRANTED=null, LOCKEDBY=null where ID=1;

create table if not exists items (
    id serial primary key,
    name varchar(2000)
);
