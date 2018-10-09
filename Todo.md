# Projecte PROP

## Restriccions:

- [ ] No es pot solapar el mateix grup d'assignatures del mateix nivell. ```P.E. Grup 11 FM amb grup 11 PRO1.```
- [ ] Els subgrups no es poden solapar amb una hora de teoria del grup gran corresponent. ```P.E. Grup 10 FM amb Grup 11 IC.```
- [ ] Les classes de laboratori s'han de realitzar a una aula que tingui PC's.
- [ ] No es pot realitzar una classe de teoria en una aula de laboratori.
- [ ] Una aula ha de tenir la capacitat => al número màxim d'assistents del grup que ha d'acollir.
- [ ] Els grups de matins s'han de situar a la franja 08h-14h.
- [ ] Els grups de tardes (>nGrupsT-nGrupsTarda) s'han de situar a la franja 14h-20h.
- [ ] Una classe de dues hores no es pot situar a les 19h.
- [ ] Una assignatura ha de tenir tantes UAH de teoria com el camp nHoresT.
- [ ] Una assignatura ha de tenir tantes UAH de laboratori com el camp nHoresL.
- [ ] Una assignatura ha de tenir tantes UAH de problemes com el camp nHoresP.
- [ ] No poden existir dues assignatures amb el mateix nom.
- [ ] No poden existir dues classes amb el mateix id.
- [ ] A les UAH, la horaF >= horaI.
- [ ] Per a cada assignatura han d'existir tants grups de teoria com indica nGrupsT.
- [ ] Per a cada grup de teoria han d'existir tants grups de laboratori com indica nGrupsL.
- [ ] Els grups de teoria i laboratori han de anomenar-se amb numeració contigua al de teoria ```P.E. Grup 10 FM amb Grup 11, 12, 13.```.
- [ ] Els subgrups no poden passar de 9.

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
- hola
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


## To Do:

- [ ] UML
- [ ] Funcions

## Millores:

- [ ] Reservar hores pels examens
- [ ] Evitar hores mortes
