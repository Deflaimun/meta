-- Criando Tabela de Contato -- 
create table META.CONTATO
(
  no_seq_id_cont            NUMBER not null,
  canal                     NUMBER(1)         ,
  valor                     VARCHAR2(30)         ,
  obs                       VARCHAR2(30)         ,
  dt_incl                   DATE not null        ,
  dt_alter                  DATE                 ,
  dt_inat                   DATE                 ,
  cd_usuario                VARCHAR2(30) not null
);

  -- Comentário de contato
comment on table META.CONTATO
  is 'Mantém informações de um contato';
 
 COMMENT ON COLUMN meta.contato.canal 
	IS 'Valores possiveis (1) Email, (2) Telefone, (3) Fixo';

-- Criando index contato
create index META.CONTATO_01 on META.CONTATO (no_seq_id_cont);
-- Adicioando PK 
alter table META.CONTATO 
  add constraint PK_CONTATO primary key (no_seq_id_cont)
  using index;
-- Criando Sequence de Contato
create sequence META.SQ_CONTATO
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

-- Criando sinonimo
create or replace public synonym CONTATO
  for META.CONTATO;
-- Dando os grants para a role
grant insert, update, delete on META.CONTATO to RL_META;