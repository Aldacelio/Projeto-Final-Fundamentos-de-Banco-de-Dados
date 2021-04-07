-- Table: public.aluguel

-- DROP TABLE public.aluguel;

CREATE TABLE public.aluguel
(
    id integer NOT NULL DEFAULT nextval('"Aluguel_id_seq"'::regclass),
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    cliente character varying COLLATE pg_catalog."default" NOT NULL,
    endereco character varying COLLATE pg_catalog."default" NOT NULL,
    bairro character varying COLLATE pg_catalog."default" NOT NULL,
    livro character varying COLLATE pg_catalog."default" NOT NULL,
    genero character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Aluguel_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.aluguel
    OWNER to postgres;