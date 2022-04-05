create or replace trigger ins_tig_t_jczczj
  after insert on r_jczczj
  for each row
begin
insert into monitor_t_jczczj
(tid, posummary, sysncstatus, sysncmessage, sysncdate, compid, isnew)
values
    (:new.tid,
     :new.posummary,
     :new.sysncstatus,
     :new.sysncmessage,
     :new.sysncdate,
     :new.compid,
     1);
end;
