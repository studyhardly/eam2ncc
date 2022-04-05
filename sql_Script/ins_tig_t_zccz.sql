create or replace trigger ins_tig_t_zccz
  after insert on r_jczccz
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
     '资产处置',
     '24');
end;
