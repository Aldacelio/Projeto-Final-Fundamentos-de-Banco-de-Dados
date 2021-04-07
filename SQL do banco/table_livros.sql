-- Table: public.livros

-- DROP TABLE public.livros;

CREATE TABLE public.livros
(
    id integer NOT NULL DEFAULT nextval('livros_id_seq'::regclass),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    editora character varying COLLATE pg_catalog."default" NOT NULL,
    autor character varying COLLATE pg_catalog."default" NOT NULL,
    genero character varying COLLATE pg_catalog."default" NOT NULL,
    numero character varying COLLATE pg_catalog."default" NOT NULL,
    ilustrador character varying COLLATE pg_catalog."default",
    CONSTRAINT livros_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.livros
    OWNER to postgres;