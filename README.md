<h1 align = "center"> 'The Healthy Corporation' - specifikacija projekta </h1>

## NAPOMENA
**TRENUTNA SPECIFIKACIJA JE REKAP ONOGA STO JE RECENO NA PREDAVANJU I STO SMO USPELI DA IZVUCEMO OD KORISNIKA, SVAKA DOPUNA JE DOBRODOSLA I PITANJA JOS VISE, ODNOSNO, TREBALI BI SVAKU NEJASNOCU DEKOMPONOVATI I KROZ INTERAKCIJU SA KORISNICIMA JE RESITI I TIME DOPUNITI SPECIFIKACIJU.** Nejasnoce su neminovne jer je bukvalno bilo **izvlacenje** informacija od asistenata(korisnika) o svemu po malo i o projektu generalno.

## O korporaciji
Zdravstvena organizacija koja je lider kako u ***inovaciji*** tako i u ***usluzi*** koju nude njhivom pacijentinma. Predstavnistva su sirom regiona, a tokom godina plan je rasiti se po severu evrope. Cilj korporacije je da brinu o svojim pacijentima i da im obezbede sto bolje i brzi oporavak.

## Predstavnistvo korporacije
U zavisnosti od uloge koju ima odredjeni clan korporacije, sa njim se vrsi zeljena interakcija odnosno kontakt. Predstavnistvo u Novom Sadu cini sledeci tim, koji ce nam biti dostupan u zavisnosti od naseg problema do problema.
  - Danijel ( **IT strucnjak** )
  - Stefan ( **Upravnik** u Novom Sadu)
  - Tomislav ( **Sekretar** ) ~ kljucna osoba funkcionalnosti sistema na dnevnom nivou
  - Simona ( **pacijenti** ) ~ krajnji korisnik i zelje, potrebe korisnika
  - Bojana ( **kardio hirurg** ) ~ predstavlja lekare i njihove zahteve za softver

## Zahtev softvera
Softver koji ce ispuniti sva ocekivanja kako korporacije tako i njihovih klijenata(pacijenata). U odnosu na ulogu u sistemu, postoje razliciti nalozi( svako bi trebao da ima svoj nalog u skladu sa njegovim potrebama). Softver za placanje je vec funkcionalan i ***nije potrebno*** voditi racuna o tome . 
<br><br>
Softver bi trebao da bude veoma brz i da na neku pretragu kartona odredjenog pacijenta brzo dobijemo trazenu informaciju. Baza podataka bi trebala da bude tako izmodelovana da bude veoma fleksibilna i da izmenom nekog podatka ne dolazi do pucanja sistema. Lokalna baza ( baza odredjene bolnice-grada) bi trebala da bude sinhronizovana sa globalnom bazom (bazom nad svim klinikama sirom regiona u kojima je korporacija rasprostranjena). Aplikacija mora biti lako izmenljiva i lako ispravljiva i dosta podlozna izmenama. Ako budemo koristili neke biblioteke, obavezno da stavimo konfiguracioni fajl u kome je opis kako se podesavaju parametri prilikom izmene nove verzije neke biblioteke.
<br><br>
Voditi racuna o bezbednosti koliko god je to moguce.





## Funkcionalnost softvera - Lekari
Lekari mogu biti lekari ***opste prakse***( obavljaju preglede pa dalje upucuju ako ima potrebe ili konstatuju dijagnozu i postupak lecenja) i ***specijalisti*** za odredjenu bransu.
  - rad sa pacijentima
    - pregled pacijenta( nakon pregleda, pacijent dobija uput ka nekom drugom lekaru ili se zakazuje operacija )
    - operacije ( operacije vrse doktori, kardio hirurzi ili specijalisti za odredjenu vrstu problema)
  - dostupnost zauzetih sala
    - koje sale su na raspolaganju ( doktor zakazuje operacije u salama koje su slobodne, i vrsi se evidencija o aktuelnosti u citavoj bolnici, radi lakse komunikacije u funkcionisanja sistema)
  - zakazivanje operacija
    - omoguciti funkcionalnost intuitivnog zakazivanja sala koje su na raspolaganju ( odosno, voditi evidenciju koje su sale slobodne koje nisu ) ( u zavisnosti od zgrade postoji razlicit broj sala )
  - mogucnost komuniciranja sa drugim klinikama u okviru korporacije, mogucnost upucivanja pacijenata na operacije u druge drzave/klinike i omogucavanje uvida o informacijama upucenog pacijenta ( svaki pacijent bi trebao da ima svoj 'karton', informacije koje ga cine jedinstvenim i sadrze istoriju njegovih bolesti kao i neophodne informacije koje idu uz karton pacijenta )
  - potrebno je i klasifikovati i slucajeve ( hitan slucaj, standardna procedura ...)
  - mogucnost davanja tretmana pacijentu ako je lekar nadredjen za tu vrstu problema
    - ako dajemo lek iz nasih zaliha, mora se voditi evidencija i o tome da se smanji odredjeni lek u skladistu, takodje lekar sme dodeliti lek samo ako pacijent nije alergican na sadrzaj zeljenog leka za upotrebu( lek mora imati informacije o sastavu i slicnim osobinama leka) 
  - mogucnost overview-a svih zakazanih pregleda/operacija  
  - posle pregleda pacijenta, u njegov karton se vrsi zavodjenje
    - koji lek je prepisan( ako je dat iz nasih zaliha, zavesti to)
    - ako je dobio uput, gde i kome
    - i ostale informacije koje idu u karton pacijenta
  - samo specijalizovan lekar za odredjenu bransu moze da porucuje lekove iz te branse
  
  
  
  
## Funkcionalnost softvera - Sekretari
Sekretara u sistemu imamo vise, i 00-24 je neko od predstavnika u bolnici ( bar po jedna osoba od svih kljucnih entiteta sistema)
  - mogucnost *premestanja lekara po salama* i zauzimanja sala za njih, za hitne slucajeve ( notifikacija treba da stize lekaru, npr na  telefon, o hitnosti ili da mu je promenjen termin(ako je pomeren termin i pacijent treba da bude obavesten)) 
    - mogucnost odlaganja operacija, u sustini punopravnost na dinamicnu izmenu stanja sistema aktuelnosti popunjenih sala,termina
    - u slucaju popunjenosti svih operacionih sala, sekretar vrsi uput na neku drugu bolnicu sa kojom je korporaciji u saradnji ili neku random ako nema saradnji 
  - mogucnost direktnog zakazivanja termina pacijentu koji nije u uopste u sistemu ***direktno*** kroz svoj nalog 
    - kako bi manu iz starog softvera unapredili kroz efikasnost novog softvera ( sekretar je u starom softveru sluzio za pomoc pri registraciji ( posto softver zahteva registrovanje radi zakazivanja termina, ako bakica dodje i zeli da zakaze termin, na uredjajima koji su u bolnici to moze odraditi, sekretar joj pomaze pri tome, sada bi bilo dobro napraviti funkcionalnost koja omogucava sekretaru kroz njegov nalog da vrsi ***direktno zakazivanje*** termina za bakicu, a ne kao u starom softveru da se prolazi kroz proces, pravljena baki profila itd itd. ))

<br>
Kada sekretar registruje nekoga preko svog naloga, on nece ostati u sistemu nego ce se samo ubaciti u odredjeni termin kako bi se obavila operacija/pregled. Da bi korinik ostao u sistemu, on samostalno mora da se registruje ili da mu neko pomogne da se registruje, kako bi najbolje mogao da koristi funkcionalnost softvera.
    
## Funkcionalnost softvera - Upravnici
Upravnikov posao je da vodi evidenciju o zaposlenima/salama/sobama/lekovima.
  - ***registruje zaposlene***(lekare, ostale zaposlene) u bolnici , evidentira njihovo radno vreme ( kako bi 00-24 bar neko bio na raspolaganju u bolnici )( nije moguc slucaj da nema bar jednog lekara u nekom trenutku u bolnici)
  - vrsenje funkcionalnosti modifikacije sala/soba (spajanje dve sobe u jednu, renoviranje i slicno)
    - kada se vrsi renoviranje, ta sala treba da bude iskljucena iz procesa mogucih
  - vodjenje evidencije sta bolnica ima od fizickih entiteta(stolice, stolovi, aparati, kreveti i ostala oprema), lekova
    - to se sve cuva u nekom skladistu a kasnije se iz njega izvlaci i rasporedjuje po potrebama 
    - skladiste za lekove sadrzi odredjenu grupaciju lekova i njih klinika moze da izdaje pacijentima
  - upravnik 'postavlja' opremu po salama i taj sadrzaj sale mora biti dostupan za uvid prilikom odabira zauzeca odredjene sale 
  - upravnik ubacuje lek u skladiste i ako je novi lek dodaje njegov sadrzaj/sastojci (1 ili 2 lekara ***moraju*** potvrditi taj unos )
    - ako ima vec leka u skladistu, samo povecava kolicinu ( u suprotnom vrsi unos odredjenih zahtevanih parametara), posle taj lek lekari imaju na raspolaganju 
  - upravnik prebacuje opremu iz jedne sale u drugu i raspolaze sa statistikom svake sale ( samo upravnik ima uvid u statistiku )
    - oprema se moze trositi(lekovi, hanzaplasti, itd) a i ne mora(stolovi,stolice,kreveti...)
  - medicinska sestra daje informaciju koliko cega gde fali, tj u kojoj operacijskoj sali sta fali i onda upravnik to treba da regulise
  
  
  
  
## Funkcionalnost softvera - IT strucnjaci (administrator)
Administrator azurira svo osoblje, korisnici se sami registruju i prijavljuju a ostalo administratori regulisu.
  - softver treba da pruzi jednostavno odrzavanje i brz rad ( sa velikom kolicinom podataka )
  - administrator **nema nalog**, on je tu kao pomoc za razvoj i odzravanje softvera koji cemo isporuciti
  
## Funkcionalnost softvera - Pacijenti
  - mogucnost odabira lekara kod kojeg zele biti pregledani
    - lekar kod kog je odabran, ima mogucnost (samo on od svih lekara) da vidi informacije o pacijentu, u slucaju hitnosti, sekretar prebacuje *pacijenta* sa jednog lekara na *drugog* kako bi ovaj dobio informacije o njemu
  - zakazivanje pregleda kod lekara opste prakse ( mogucnost izmene termina pregleda, dinamicnost zakazanog pregleda u nekom pristojnom okviru- 1/2 dana pre pregleda)
    - nakon registracije vidi samo doktore opste prakse ( dobro bi bilo da imaju neke statistike i ocene tih doktora zasnovane na predjasnjem iskustvu)
  - mogucnost overview-a i izmena nekih od osnovnih informacija u vezi njegovog profila/kartona  
  - mogucnost ostavljanja feedbacka 
  - ako pacijent ostaje posle operacije u klinici(odredjenoj sobi), vodi se evidencija u zauzecu i ko je i kad i gde lezao
  
<br>

Trebalo bi omoguciti deo gde se pacijentu plasira zagovaranje **zdravog zivota** kroz neki npr. blog i ako zeli da se pacijent moze preplatiti na **newsletter** gde ce dobijati informacije o nekim bas bitnim temama (npr. pojava X virusa u srbiji i nabolji nacini prevencije i saveti ), npr neki *chatbot* koji ce davati odgovore na najcesca pitanja itd.

## Funkcionalnosti softvera - generalno
Bitna stvar je i prikupljanje informacija tj. kreiranje izvestaja kako bi videli u kojim salama je najvise operacija, u kom periodu kako bi upravnik mogao da zna kada su lekari najpotrebniji tj. u kom periodu dana(tokom noci, dana itd). Taj izvestaj bi trebao da bude parametrizovan ( upravnik bira parametre i na osnovu njih dobija zeljeni izvestaj u okviru pdf-a ili neke druge forme, npr. za neki Y vremenski period da vratimo zauzece prostorije X itd. )
<br><br>
Treba da postoji forma u kojoj se moze dati feedback, kako na lekare tako i na softver i na ostale komponente citavog sistema.
<br><br>
**Prostorije** su podeljene na sobe za **hitne** slucajeve, sobe za pacijente **nakon operacije**, **operativne sale**, obicne **sale za preglede**
<br><br>
Softver mora biti spreman za laku tranziciju sa jednog jezika na drugi ( ne treba da bude inicijalno na engleskom jer pravimo aplikaciju namenjenu trenutno za region ( tacnije sad samo za Novi Sad - Srbiju ), jer 'baka Nada' nije upoznata sa engleskim, nego treba da bude spremna za laku tranziciju na drugi jezik)
## Recnik
  - ***stari softver*** : softver koji se koristio *pre* nego sto je korporacija odlucila da nas unajmi za izradu novog
  - ***sala***: operaciona sala u kojoj doktori vrse operacije nad pacijentima klinike
<h1 align = "center"> Van konteksta specifikacije projekta </h1>

## Pitanja za sledeci sastanak
**OVDE DODATI PITANJA ILI U NEKI DRUGI FAJL KAKO BI POSLE MOGLI KONCIZNIJE DOBIJATI DETALJNIJE INFORMACIJE O NEJASNOCAMA KOJE SU NASTALE**
  1. ...
  2. ...
## Tehnologija izrade
Sa sadasnjim informacijama zakljucujemo da bi pozeljno bilo da projekat implementiramo na osnovu C#

