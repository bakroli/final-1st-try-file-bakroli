# Aranybánya radar
## Bevezetés
Egy újfajta radart találtak fel, mely képes a talajban levő barlangok és nemesfémek megtalálására.

Feljesszétek le azt a programkódot, mely a radar kimenetét fel tudja dolgozni.
A radar a talaj metszeteiről készít képeket, melyeket fájlokba ment, szöveges formátumban.

## Feladatleírás
Ahol talaj van, ott a `'#'` karakter található. Ahol barlang van, ott a `' '` karakter.
Ahol pedig aranyat érzékel, oda a `'g'` karakter kerül.
Egy aranyat könnyebb kibányászni, ha barlangban található.
Egy arany akkor van barlangban, ha
 - balról vagy jobbról barlang van mellette: `###g  ##`
 - mindkét irányból barlang van mellette:    `### g  ##`
 - ha olyan arany van mellette, amelyik barlangban van: ` ##ggg     ##` &larr; itt tehát minden arany barlangban van. ( *Ez egy kicsit nehezebb feltétel, és csak egy teszt függ tőle. Ha nem megy, ugorjátok át* )

Ha az arany a radarkép szélén van, a radarkép nem látható széle talajnak számít.

A radarkimenet feldolgozója, amit implementálnod kell (`SonarScanResultProcessor`),
megkapja a radarképet tartalmazó fájl nevét a `process` metóduson keresztül.
Ezt olvasd be, majd térj vissza egy report objektummal (`SurveyReport`), ami tartalmazza:
- a könnyen kibányászható aranyakat (elkérhető az `int getEasyGoldCount()` getterel)
- az összes arany számát (elkérhető az `int getGoldCount()` getterel)

Példák:
Fájl:
```
##g###
#####g
#  g #
```
Eredmény: `1, 3` (könnyen bánászható/összes arany)

Fájl:
```
#####       g#
##g#g#  g   g#
```
Eredmény:   `3, 5`
