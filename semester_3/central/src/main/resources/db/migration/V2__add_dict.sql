

CREATE TABLE public.counterparty (
    id bigint NOT NULL
);


ALTER TABLE public.counterparty OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24434182)
-- Name: dict_country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dict_country (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);


ALTER TABLE public.dict_country OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24434190)
-- Name: dict_userrole; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dict_userrole (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);


ALTER TABLE public.dict_userrole OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24434214)
-- Name: dictionary_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dictionary_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dictionary_seq OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24434198)
-- Name: organization; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.organization (
    id bigint NOT NULL,
    name character varying(255),
    country_id bigint
);


ALTER TABLE public.organization OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24434216)
-- Name: organization_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.organization_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.organization_seq OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24434203)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    password character varying(255),
    status character varying(255),
    username character varying(255),
    organization_id bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24434211)
-- Name: users_dict_userrole; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_dict_userrole (
    user_id bigint NOT NULL,
    roles_id bigint NOT NULL
);


ALTER TABLE public.users_dict_userrole OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24434218)
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_seq OWNER TO postgres;

--
-- TOC entry 2145 (class 2606 OID 24434181)
-- Name: counterparty counterparty_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.counterparty
    ADD CONSTRAINT counterparty_pkey PRIMARY KEY (id);


--
-- TOC entry 2147 (class 2606 OID 24434189)
-- Name: dict_country dict_country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dict_country
    ADD CONSTRAINT dict_country_pkey PRIMARY KEY (id);


--
-- TOC entry 2149 (class 2606 OID 24434197)
-- Name: dict_userrole dict_userrole_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dict_userrole
    ADD CONSTRAINT dict_userrole_pkey PRIMARY KEY (id);


--
-- TOC entry 2151 (class 2606 OID 24434202)
-- Name: organization organization_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT organization_pkey PRIMARY KEY (id);


--
-- TOC entry 2153 (class 2606 OID 24434210)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2154 (class 2606 OID 24434220)
-- Name: counterparty fk1ne5yputsy33kvwo56cyxyln9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.counterparty
    ADD CONSTRAINT fk1ne5yputsy33kvwo56cyxyln9 FOREIGN KEY (id) REFERENCES public.organization(id);


--
-- TOC entry 2156 (class 2606 OID 24434230)
-- Name: users fk50osnnna6nfmllc7yk6jc35wk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk50osnnna6nfmllc7yk6jc35wk FOREIGN KEY (organization_id) REFERENCES public.organization(id);


--
-- TOC entry 2157 (class 2606 OID 24434235)
-- Name: users_dict_userrole fk8vh954ilglxadvwkmf9a25s7q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_dict_userrole
    ADD CONSTRAINT fk8vh954ilglxadvwkmf9a25s7q FOREIGN KEY (roles_id) REFERENCES public.dict_userrole(id);


--
-- TOC entry 2158 (class 2606 OID 24434240)
-- Name: users_dict_userrole fkh7ae0kgmvpnt04o58750o7wi1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_dict_userrole
    ADD CONSTRAINT fkh7ae0kgmvpnt04o58750o7wi1 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2155 (class 2606 OID 24434225)
-- Name: organization fkl7iykknpqcr3bnbnu6giug7ia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT fkl7iykknpqcr3bnbnu6giug7ia FOREIGN KEY (country_id) REFERENCES public.dict_country(id);


-- Completed on 2022-05-11 11:06:42 MSK

--
-- PostgreSQL database dump complete
--
