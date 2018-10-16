# Projecte PROP

## Restriccions:

### Unàries:

#### - Tocables:


#### - Intocables:
- [ ] Els grups de matins s'han de situar a la franja horaInici-horaCanviFranja.
- [ ] Els grups de tardes s'han de situar a la franja horaCanviFranja-horaFi.
- [ ] Els grups de matins han de ser iguals a nGrupsT-nGrupsTarda.
- [ ] No es pot realitzar una classe de laboratori a una aula que tingui teoria.
- [ ] No es pot realitzar una classe de teoria en una aula de laboratori.
- [ ] Una aula ha de tenir la capacitat => al número màxim d'assistents del grup que ha d'acollir.
- [ ] La horaF >= horaI.
- [ ] Els grups de teoria i laboratori han de anomenar-se amb numeració contigua al de teoria ```P.E. Grup 10 FM amb Grup 11, 12, 13.```.
- [ ] Els subgrups no poden passar de 9.


### Binàries:

#### - Tocables:

#### - Intocables:
- [ ] No es pot solapar el mateix grup d'assignatures del mateix nivell (o correquisits). ```P.E. Grup 11 FM amb grup 11 PRO1``` / ``` Grup 10 FM amb grup 10 F```
- [ ] Els subgrups no es poden solapar amb una hora de teoria del grup "mare" del mateix nivell (o corequisits). ```P.E. Grup 10 FM amb Grup 11 IC```
- [ ] Una assignatura ha de tenir tantes UAH de teoria com el camp nHoresT.
- [ ] Una assignatura ha de tenir tantes UAH de laboratori com el camp nHoresL.
- [ ] Una assignatura ha de tenir tantes UAH de problemes com el camp nHoresP.

- [ ] No poden existir dues assignatures amb el mateix nom.
- [ ] No poden existir dues aules amb el mateix id.
- [ ] No poden existir dos nivells amb el mateix nom.
- [ ] No poden existir dos grups amb el mateix nom dins una assignatura.

- [ ] Per a cada assignatura han d'existir tants grups de teoria com indica nGrupsT.
- [ ] Per a cada grup de teoria han d'existir tants grups de laboratori com indica nGrupsL.
- [ ] Per a cada grup de teoria han d'existir tants grups de problemes com indica nGrupsP.

### N-àries:

#### - Tocables:

#### - Intocables:

## Casos d'ús:

### 1a pantalla:
- afegirPeriodeLectiu()
    - Hora inici classes
    - Hora fi classes
    - Hora canvi període mati/tarda

### 2a pantalla:

- afegirAules()
    - Identificador d'aula
    - Teoria/problemes o laboratori?
    - Capacitat

### 3a pantalla:

- afegirNivells()
    - Nombre de nivells

### 4a pantalla:

- afegirAssignatura()
    - Nivell
    - Nom
    - Hores de teoria
    - Hores de problemes
    - Hores de laboratori
    - Número de grups de teoria
    - Número de subgrups de problemes (per grup de teoria)
    - Número de subgrups de laboratori (per grup de teoria)
    - Número de grups de matins
    - Agrupació hores

### 5a pantalla:
- Generar horaris

## Preguntes:
- Constructora nula
- Restriccions (unàries...)
- Classes lab mal escrites -> Aules de teoria pero horari de lab
- Pot existir una assignatura amb 0h teoria? -> Restricció

## To Do:

- [ ] UML
- [ ] Funcions
- [ ] Casos d'ús

## Millores:
- [ ] Filtrar horari per nivell
- [ ] Filtrar horari per subgrup
- [ ] Reservar hores pels examens
- [ ] Evitar hores mortes
