-- Create table
create table MONITOR_T_JCZCZJ
(
    tid          VARCHAR2(255) not null,
    posummary    VARCHAR2(255),
    sysncstatus  NUMBER(2),
    sysncmessage VARCHAR2(500),
    sysncdate    DATE,
    compid       VARCHAR2(100),
    isnew        NUMBER(2)
)
    tablespace NSOAWARE
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
alter table MONITOR_T_JCZCZJ
    add primary key (TID)
    using index
  tablespace NSOAWARE
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
