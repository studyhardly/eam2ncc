create or replace trigger ins_tig_t_zcsbxxbd
  after insert on r_jczcsbbd
  for each row
begin
insert into MONITOR_T_YWDJ
(tid, posummary, sysncstatus, sysncmessage, sysncdate, compid, isnew,ywtype,ywtypeid)
values
    (:new.tid,
     :new.posummary,
     :new.sysncstatus,
     :new.sysncmessage,
     :new.sysncdate,
     :new.compid,
     1,
     '资产设备变动',
     '22');
end;
