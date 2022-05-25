--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2022-05-11 13:14:02 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 24434334)
-- Name: dict_units; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dict_units (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);


ALTER TABLE public.dict_units OWNER TO postgres;

--
-- TOC entry 2272 (class 0 OID 24434334)
-- Dependencies: 211
-- Data for Name: dict_units; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.dict_units (id, code, name) VALUES (1, '6', 'МЕТР');
INSERT INTO public.dict_units (id, code, name) VALUES (2, '55', 'КВАДРАТНЫЙ МЕТР');
INSERT INTO public.dict_units (id, code, name) VALUES (3, '166', 'КИЛОГРАММ');
INSERT INTO public.dict_units (id, code, name) VALUES (4, '163', 'ГРАММ');
INSERT INTO public.dict_units (id, code, name) VALUES (5, '113', 'КУБИЧЕСКИЙ МЕТР');
INSERT INTO public.dict_units (id, code, name) VALUES (6, '112', 'ЛИТР');
INSERT INTO public.dict_units (id, code, name) VALUES (7, '797', 'СТО ШТУК');
INSERT INTO public.dict_units (id, code, name) VALUES (8, '715', 'ПАРА');
INSERT INTO public.dict_units (id, code, name) VALUES (9, '798', 'ТЫСЯЧА ШТУК');
INSERT INTO public.dict_units (id, code, name) VALUES (10, '796', 'ШТУКА');
INSERT INTO public.dict_units (id, code, name) VALUES (11, '306', 'ГРАММ ДЕЛЯЩИХСЯ ИЗОТОПОВ');
INSERT INTO public.dict_units (id, code, name) VALUES (12, '185', 'ГРУЗОПОДЪЕМНОСТЬ В ТОННАХ');
INSERT INTO public.dict_units (id, code, name) VALUES (13, '861', 'КИЛОГРАММ АЗОТА');
INSERT INTO public.dict_units (id, code, name) VALUES (14, '859', 'КИЛОГРАММ ГИДРОКСИДА КАЛИЯ');
INSERT INTO public.dict_units (id, code, name) VALUES (15, '863', 'КИЛОГРАММ ГИДРОКСИДА НАТРИЯ');
INSERT INTO public.dict_units (id, code, name) VALUES (16, '852', 'КИЛОГРАММ ОКСИДА КАЛИЯ');
INSERT INTO public.dict_units (id, code, name) VALUES (17, '841', 'КИЛОГРАММ ПЕРОКСИДА ВОДОРОДА');
INSERT INTO public.dict_units (id, code, name) VALUES (18, '865', 'КИЛОГРАММ ПЯТИОКИСИ ФОСФОРА');
INSERT INTO public.dict_units (id, code, name) VALUES (19, '845', 'КИЛОГРАММ 90 %-ГО СУХОГО ВЕЩЕСТВА');
INSERT INTO public.dict_units (id, code, name) VALUES (20, '867', 'КИЛОГРАММ УРАНА');
INSERT INTO public.dict_units (id, code, name) VALUES (21, '831', 'ЛИТР ЧИСТОГО (100%) СПИРТА');
INSERT INTO public.dict_units (id, code, name) VALUES (22, '162', 'МЕТРИЧЕСКИЙ КАРАТ(1КАРАТ=2*10(-4)КГ');
INSERT INTO public.dict_units (id, code, name) VALUES (23, '246', '1000 КИЛОВАТТ-ЧАС');
INSERT INTO public.dict_units (id, code, name) VALUES (24, '305', 'КЮРИ');
INSERT INTO public.dict_units (id, code, name) VALUES (25, '111', 'КУБИЧЕСКИЙ САНТИМЕТР');
INSERT INTO public.dict_units (id, code, name) VALUES (26, '130', '1000 ЛИТРОВ');
INSERT INTO public.dict_units (id, code, name) VALUES (27, '114', '1000 КУБИЧЕСКИХ МЕТРОВ');
INSERT INTO public.dict_units (id, code, name) VALUES (28, '168', 'ТОННА, МЕТРИЧЕСКАЯ ТОННА (1000 КГ)');
INSERT INTO public.dict_units (id, code, name) VALUES (29, '251', 'ЛОШАДИНАЯ СИЛА');
INSERT INTO public.dict_units (id, code, name) VALUES (30, '214', 'КИЛОВАТТ');


--
-- TOC entry 2141 (class 2606 OID 24434341)
-- Name: dict_units dict_units_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dict_units
    ADD CONSTRAINT dict_units_pkey PRIMARY KEY (id);


-- Completed on 2022-05-11 13:14:02 MSK

--
-- PostgreSQL database dump complete
--

