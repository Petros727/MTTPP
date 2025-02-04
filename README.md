# Automatizirano Testiranje Web Shopa

Ovaj projekt implementira automatizirano testiranje web shopa pomoću Playwright biblioteke u kombinaciji s JUnit 5. Cilj testova je provjeriti ključne funkcionalnosti web aplikacije, uključujući postavljanje profila, dodavanje proizvoda u košaricu, proces naplate, prijavu administratora i pristup izvještajima.

---

 Tehnologije Korištene

- Java – programski jezik korišten za pisanje testova
- Playwright – alat za automatizirano testiranje web aplikacija
- JUnit 5 – testni okvir za strukturiranje i izvođenje testova
- Maven – alat za upravljanje ovisnostima i izgradnju projekta
- IntelliJ IDEA – razvojno okruženje u kojem su testovi razvijeni i pokrenuti

---

Postavljanje Projekta

Za pokretanje projekta potrebno je:

1. Preuzeti i instalirati potrebne alate:
   - [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
   - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
   - [Maven](https://maven.apache.org/download.cgi)

2. Klonirati projekt s GitHub repozitorija:
   ```bash
   git clone https://github.com/Petros727/MTTPP.git
   cd MTTPP
   ```

3. Otvoriti projekt u IntelliJ IDEA.

4. Provjeriti da su potrebne ovisnosti instalirane (navedene u `pom.xml`):
   - Playwright za Java (`com.microsoft.playwright`)
   - JUnit 5 (`org.junit.jupiter`)

5. Pokrenuti testove unutar IntelliJ IDEA:
   - Otvoriti Run/Debug Configurations
   - Odabrati testnu klasu `WebShopTest`
   - Pokrenuti testove pritiskom na "Run"

---

Testni Slučajevi

Projekt sadrži pet testnih slučajeva, koji pokrivaju osnovne funkcionalnosti web shopa:

1. Postavljanje korisničkog profila  
   - Pristupanje stranici "Moj profil"
   - Unos broja mobitela i traženje PIN-a
   - Unos PIN-a, OIB-a, emaila i ostalih podataka
   - Spremanje podataka i potvrda unosa

2. Dodavanje proizvoda u košaricu  
   - Odabir prvog proizvoda i unos količine
   - Dodavanje proizvoda u košaricu
   - Ponavljanje postupka s drugim proizvodom
   - Pregled košarice

3. Proces naplate (Checkout Process)  
   - Pokretanje procesa narudžbe
   - Unos adrese i grada
   - Odabir metode dostave i plaćanja
   - Potvrda narudžbe i provjera uspješnosti

4. Prijava administratora  
   - Pristup stranici za administraciju
   - Unos korisničkog imena i lozinke
   - Unos PIN-a za otključavanje sustava
   - Provjera prikaza administratorskog sučelja

5. Pristup izvještajima  
   - Otvaranje sekcije "Izvještaji"
   - Provjera prikaza ključnih izvještaja

