CREATE DATABASE clg_azs_fleet
	WITH OWNER = azs
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    CONNECTION LIMIT = -1;


CREATE TABLE public.motorista (
    id bigint NOT NULL,
    categoria_cnh integer,
    cpf character varying(255),
    data_nascimento date,
    expedicao_cnh date,
    nome character varying(255),
    numero_cnh character varying(255),
    sexo integer,
    validade_cnh date
);
ALTER TABLE public.motorista OWNER TO azs;
ALTER TABLE ONLY public.motorista
    ADD CONSTRAINT motorista_pkey PRIMARY KEY (id);

CREATE TABLE public.veiculo (
    categoria_veiculo integer NOT NULL,
    id bigint NOT NULL,
    ano_fabricacao date,
    chassi character varying(255),
    cidade character varying(255),
    estado character varying(255),
    fabricante character varying(255),
    modelo character varying(255),
    placa character varying(255),
    renavam character varying(255),
    tipo_cavalo integer,
    tipo_reboque integer
);
ALTER TABLE public.veiculo OWNER TO azs;
ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_pkey PRIMARY KEY (id);

CREATE TABLE public.viagem (
    id bigint NOT NULL,
    data_fim date,
    data_inicio date,
    produto_transportado character varying(255),
    status_viagem integer,
    valor_frete double precision,
    motorista_id bigint,
    veiculo_id bigint
);
ALTER TABLE public.viagem OWNER TO azs;
ALTER TABLE ONLY public.viagem
    ADD CONSTRAINT viagem_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.viagem
    ADD CONSTRAINT motorista_fkey FOREIGN KEY (motorista_id) REFERENCES public.motorista(id) ON DELETE CASCADE;
ALTER TABLE ONLY public.viagem
    ADD CONSTRAINT veiculo_fkey FOREIGN KEY (veiculo_id) REFERENCES public.veiculo(id) ON DELETE CASCADE;


CREATE SEQUENCE public.motorista_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.motorista_id_seq OWNER TO azs;

CREATE SEQUENCE public.veiculo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.veiculo_id_seq OWNER TO azs;

CREATE SEQUENCE public.viagem_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.viagem_id_seq OWNER TO azs;
  

INSERT INTO public.motorista(id, categoria_cnh, cpf, data_nascimento, expedicao_cnh, nome, 
numero_cnh, sexo, validade_cnh)
VALUES (1, 0, "29170981043", "1990-01-01", "2016-01-01", "Motorista 1", 
"111111", 0, "2020-01-01");

INSERT INTO public.motorista(id, categoria_cnh, cpf, data_nascimento, expedicao_cnh, nome, 
numero_cnh, sexo, validade_cnh)
VALUES (2, 0, "04634029014", "1990-01-02", "2016-01-02", "Motorista 2", 
"222222", 0, "2020-01-02");

INSERT INTO public.motorista(id, categoria_cnh, cpf, data_nascimento, expedicao_cnh, nome, 
numero_cnh, sexo, validade_cnh)
VALUES (3, 0, "23114833071", "1990-01-03", "2016-01-03", "Motorista 3", 
"333333", 0, "2020-01-03");


INSERT INTO public.veiculo(categoria_veiculo, id, ano_fabricacao, chassi, cidade, estado, 
fabricante, modelo, placa, renavam, tipo_cavalo, tipo_reboque)
VALUES (0, 1, "2000-01-01", "111111111", "Uberlandia", "MG", 
"Fabricante 1", "Modelo 1", "AAA1111", "111111111", null, null);

INSERT INTO public.veiculo(categoria_veiculo, id, ano_fabricacao, chassi, cidade, estado, 
fabricante, modelo, placa, renavam, tipo_cavalo, tipo_reboque)
VALUES (1, 2, "2000-01-02", "222222222", "Uberaba", "MG", 
"Fabricante 2", "Modelo 2", "BBB2222", "222222222", 0, null);

INSERT INTO public.veiculo(categoria_veiculo, id, ano_fabricacao, chassi, cidade, estado, 
fabricante, modelo, placa, renavam, tipo_cavalo, tipo_reboque)
VALUES (2, 3, "2000-01-03", "333333333", "Ituiutaba", "MG", 
"Fabricante 3", "Modelo 3", "CCC3333", "333333333", null, 0);


INSERT INTO public.viagem(id, data_fim, data_inicio, produto_transportado, status_viagem, 
valor_frete, motorista_id, veiculo_id)
VALUES (1, "2020-02-01", "2020-01-01", "Produto 1", 0, 
100, 1, 1);

INSERT INTO public.viagem(id, data_fim, data_inicio, produto_transportado, status_viagem, 
valor_frete, motorista_id, veiculo_id)
VALUES (1, "2020-03-01", "2020-02-01", "Produto 2", 1, 
200, 2, 2);

INSERT INTO public.viagem(id, data_fim, data_inicio, produto_transportado, status_viagem, 
valor_frete, motorista_id, veiculo_id)
VALUES (1, "2020-04-01", "2020-03-01", "Produto 3", 2, 
300, 3, 3);