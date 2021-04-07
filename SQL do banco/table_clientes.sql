-- Table: public.clientes

-- DROP TABLE public.clientes;

CREATE TABLE public.clientes
(
    id integer NOT NULL DEFAULT nextval('clientes_id_seq'::regclass),
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    idade character varying COLLATE pg_catalog."default" NOT NULL,
    endereco character varying COLLATE pg_catalog."default" NOT NULL,
    bairro character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT clientes_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.clientes
    OWNER to postgres;