create table if not exists DATABASECHANGELOGLOCK (
    ID int,
    LOCKED int,
    LOCKGRANTED DATE,
    LOCKEDBY VARCHAR(255)
);

UPDATE DATABASECHANGELOGLOCK SET LOCKED=0, LOCKGRANTED=null, LOCKEDBY=null where ID=1;

create table if not exists items (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp
);
