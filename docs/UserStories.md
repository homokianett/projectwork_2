## Digital Bank user stories ##

US1: Bejelentkezés

Rules:

1. A felhasználónak érvényes felhasználónév és jelszó esetén be kell tudni lépnie.
2. Érvénytelen adatok esetén hibaüzenet jelenjen meg.
3. Üres mezők esetén a bejelentkezés nem indulhat el.
4. Sikeres belépés után a felhasználó a kezdőlapra kerül.

Examples:

1./ 4. Pozitív eset: “teszt1 / jelszo1” -> sikeres bejelentkezés -> kezdőlap megjelenik
2. Rossz jelszó: “teszt1 / xxx” -> Hibaüzenet
3. üres felhasználónév: “ / jelszo1” -> Hibaüzenet
3. Üres jelszó: “teszt1 / ” -> Hibaüzenet


US2: VISA átutalás indítása

Rules:
1. A felhasználónak meg kell adnia a célszámlaszámot és az összeget.
2. Az összeg nem lehet 0 vagy negatív.
3. Sikeres utalás esetén visszaigazolás jelenjen meg.
4. Ha az egyenlegnél nagyobb az összeg, hibaüzenet jön.

Examples: 
Egyenleg: 11000
1. Összeg = 10000, egyenleg rendben -> sikeres átutalás
2. Összeg = -100 -> Error
2. Összeg = 0 -> Error
4. Összeg: 15000 -> Error


US3: Készpénzfelvétel 

Rules: 
1. A felvételhez szolgáló számlát kötelező kiválasztani.
2. A felvétel összege nem lehet üres, 0 vagy negatív.
3. A felvétel összege nem haladhatja meg a számla aktuális egyenlegét.
4. Sikeres felvétel esetén megerősítő üzenet jelenjen meg.
5. A “Visszaállít” gomb törli a bevitt adatokat.
6. Ha a számla nem érhető el vagy nincs jogosultság, hibaüzenet jelenjen meg.
7. Érvényes felvétel esetén a számla egyenlege frissüljön.

Examples: 
Egyenleg: 10000
                                        Bevitt összeg       Üzenet
1. Sikeres készpénzfelvétel            | 5000           | sikerült üzenet, új egyenleg: 5000
2. Összeg 0                            | 0              | hibaüzenet: "Érvénytelen összeg."
3. Magasabb összeg, mint az egyenleg   | 100000         | hibaüzenet: "Nincs elegendő összeg a számlán."
4. Nincs kiválasztva számla            | 5000           | hibaüzenet: "Válasszony számlát!"
5. Visszaállít                         | 5000           | kiindulási állapotra ugrik


US4: Folyószámla létrehozása 

Rules:

Examples:


US5: Belső Átutalás

Rules:

Examples: