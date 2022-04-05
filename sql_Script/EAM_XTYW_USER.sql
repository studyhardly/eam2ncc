drop table EAM_XTYW_USER;
-- Create table
create table EAM_XTYW_USER
(
  usercode VARCHAR2(255) not null,
  username VARCHAR2(255),
  status   NUMBER(2),
  remark   VARCHAR2(255)
)
tablespace FMIS9999
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 80K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table EAM_XTYW_USER
  add primary key (USERCODE)
  using index 
  tablespace FMIS9999
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 80K
    next 1M
    minextents 1
    maxextents unlimited
  );
