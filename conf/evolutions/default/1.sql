# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table message (
  id                        bigserial not null,
  name                      varchar(255),
  mail                      varchar(255),
  message                   varchar(255),
  postdate                  timestamp,
  constraint pk_message primary key (id))
;

create table projects (
  id                        bigserial not null,
  name                      varchar(255),
  explanation               varchar(255),
  closing_date              timestamp,
  progress_meter            float,
  finish_flag               varchar(255),
  constraint pk_projects primary key (id))
;

create table tasks (
  id                        bigserial not null,
  project_id                bigint,
  name                      varchar(255),
  explanation               varchar(255),
  start_date                timestamp,
  closing_date              timestamp,
  staff_id                  integer,
  category_id               integer,
  finish_flag               integer,
  constraint pk_tasks primary key (id))
;




# --- !Downs

drop table if exists message cascade;

drop table if exists projects cascade;

drop table if exists tasks cascade;

