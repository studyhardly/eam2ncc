-- Create table
create table MONITOR_T_YWDJ
(
    tid          VARCHAR2(255) not null,
    posummary    VARCHAR2(255),
    sysncstatus  NUMBER(2),
    sysncmessage VARCHAR2(2000),
    sysncdate    DATE,
    compid       VARCHAR2(100),
    isnew        NUMBER(2),
    ywtype       VARCHAR2(100),
    ywtypeid     VARCHAR2(100)
)
    tablespace NSOAWARE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 80K
    next 16K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table MONITOR_T_YWDJ
    add constraint PK_ID primary key (TID)
    using index
  tablespace NSOAWARE
  pctfree 10
  initrans 2
  maxtrans 255;
