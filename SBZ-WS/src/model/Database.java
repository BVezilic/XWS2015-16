package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Singleton;

import jess.JessException;
import jess.Rete;
import rezoner.Rezoner;

@Singleton
public class Database implements Serializable {

	private static final long serialVersionUID = 6692747052696354138L;

	private ArrayList<AkcijskiDogadjaj> akcijskiDogadjaji = new ArrayList<AkcijskiDogadjaj>();
	private ArrayList<Artikal> artikli = new ArrayList<Artikal>();
	private ArrayList<KategorijaArtikla> kategorijeArtikla = new ArrayList<KategorijaArtikla>();
	private ArrayList<KategorijaKupca> kategorijeKupca = new ArrayList<KategorijaKupca>();
	private ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	private ArrayList<Popust> popustiZaRacun = new ArrayList<Popust>();
	private ArrayList<PopustZaPojedinacnuStavku> popustiZaStavku = new ArrayList<PopustZaPojedinacnuStavku>();
	private ArrayList<PragPotrosnje> pragoviPotrosnje = new ArrayList<PragPotrosnje>();
	private ArrayList<ProfilKupca> profiliKupca = new ArrayList<ProfilKupca>();
	private ArrayList<Racun> racuni = new ArrayList<Racun>();
	private ArrayList<StavkaRacuna> stavkeRacuna = new ArrayList<StavkaRacuna>();

	private ArrayList<StanjeRacuna> stanjaRacuna = new ArrayList<StanjeRacuna>();
	private ArrayList<TipPopusta> tipoviPopusta = new ArrayList<TipPopusta>();
	private ArrayList<UlogaKorisnika> ulogeKorisnika = new ArrayList<UlogaKorisnika>();

	private Rete engine = Rezoner.engine;

	public Database() {
		super();

		UlogaKorisnika uk1 = UlogaKorisnika.KUPAC;
		UlogaKorisnika uk2 = UlogaKorisnika.PRODAVAC;
		UlogaKorisnika uk3 = UlogaKorisnika.MENADZER;

		AkcijskiDogadjaj ad1 = new AkcijskiDogadjaj("ad1", "Leto",
				parseDate("21/06/2016"), parseDate("21/09/2016"), 0.20);
		AkcijskiDogadjaj ad2 = new AkcijskiDogadjaj("ad2", "Jesen",
				parseDate("22/09/2016"), parseDate("21/12/2016"), 0.15);
		AkcijskiDogadjaj ad3 = new AkcijskiDogadjaj("ad3", "Zima",
				parseDate("22/12/2016"), parseDate("21/03/2016"), 0.33);
		AkcijskiDogadjaj ad4 = new AkcijskiDogadjaj("ad4", "Prolece",
				parseDate("21/06/2016"), parseDate("21/09/2016"), 0.20);
		AkcijskiDogadjaj ad5 = new AkcijskiDogadjaj("ad5", "PocetakSkole",
				parseDate("1/08/2016"), parseDate("1/09/2016"), 0.25);
		AkcijskiDogadjaj ad6 = new AkcijskiDogadjaj("ad6", "NovaGodina",
				parseDate("25/12/2016"), parseDate("07/01/2016"), 0.40);

		KategorijaArtikla ka1 = new KategorijaArtikla("ka1", null,
				"Kancelarijska oprema", 0.15);
		KategorijaArtikla ka2 = new KategorijaArtikla("ka2", ka1,
				"Skolski pribor", 0.20);
		KategorijaArtikla ka3 = new KategorijaArtikla("ka3", ka1,
				"Elektronika", 0.25);
		KategorijaArtikla ka4 = new KategorijaArtikla("ka4", null, "Sokovi",
				0.10);
		KategorijaArtikla ka5 = new KategorijaArtikla("ka5", null,
				"Sportska oprema", 0.33);

		Artikal ar1 = new Artikal("ar1", "Olovka", ka2, 25, 100, 50,
				parseDate("1/1/2014"), false, false);
		Artikal ar2 = new Artikal("ar2", "Lenjir", ka2, 100, 50, 25,
				parseDate("1/1/2014"), false, false);
		Artikal ar3 = new Artikal("ar3", "Gumica", ka2, 100, 50, 25,
				parseDate("1/1/2014"), false, false);
		Artikal ar4 = new Artikal("ar4", "Televizor", ka3, 20000, 5, 1,
				parseDate("1/1/2014"), false, false);
		Artikal ar5 = new Artikal("ar5", "Racunar", ka3, 30000, 5, 1,
				parseDate("1/1/2014"), false, false);
		Artikal ar6 = new Artikal("ar6", "Coca cola", ka4, 120, 30, 20,
				parseDate("1/1/2014"), false, false);
		Artikal ar7 = new Artikal("ar7", "Pepsi cola", ka4, 90, 30, 20,
				parseDate("1/1/2014"), false, false);
		Artikal ar8 = new Artikal("ar8", "Sok od jabuke", ka4, 90, 30, 20,
				parseDate("1/1/2014"), false, false);
		Artikal ar9 = new Artikal("ar9", "Lav pivo", ka4, 100, 30, 20,
				parseDate("1/1/2014"), false, false);
		Artikal ar10 = new Artikal("ar10", "Fudbalska lopta", ka5, 3000, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar11 = new Artikal("ar11", "Teniske loptice", ka5, 500, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar12 = new Artikal("ar12", "Teg", ka5, 500, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar13 = new Artikal("ar13", "Kapa", ka5, 750, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar14 = new Artikal("ar13", "Mis", ka3, 1000, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar15 = new Artikal("ar13", "Tastatura", ka3, 1500, 10, 2,
				parseDate("1/1/2014"), false, false);
		Artikal ar16 = new Artikal("ar13", "Kamera", ka3, 2000, 10, 2,
				parseDate("1/1/2014"), false, false);

		PragPotrosnje pp1 = new PragPotrosnje(0, 10000);
		PragPotrosnje pp2 = new PragPotrosnje(10000, 100000);
		PragPotrosnje pp3 = new PragPotrosnje(100000, Double.MAX_VALUE);

		KategorijaKupca kk1 = new KategorijaKupca("kk1", "Bronzana kategorija",
				pp1);
		KategorijaKupca kk2 = new KategorijaKupca("kk2", "Srebrna kategorija",
				pp2);
		KategorijaKupca kk3 = new KategorijaKupca("kk3", "Zlatna kategorija",
				pp3);

		Korisnik ko1 = new Korisnik("kupac1", "Pera", "Peric", "p", uk1,
				parseDate("1/1/2015"));
		Korisnik ko2 = new Korisnik("kupac2", "Marko", "Markovic", "m", uk1,
				parseDate("2/2/2014"));
		Korisnik ko3 = new Korisnik("kupac3", "Nikola", "Nikolic", "n", uk1,
				parseDate("3/3/2013"));
		Korisnik ko4 = new Korisnik("prodavac1", "Jovan", "Jovanovic", "j",
				uk2, parseDate("4/4/2012"));
		Korisnik ko5 = new Korisnik("prodavac2", "Ana", "Anic", "a", uk2,
				parseDate("5/5/2012"));
		Korisnik ko6 = new Korisnik("menadzer1", "Djordje", "Djordjevic", "d",
				uk3, parseDate("6/6/2011"));

		ProfilKupca pk1 = new ProfilKupca(ko1, "Zeleznicka 1", 0, kk1);
		ProfilKupca pk2 = new ProfilKupca(ko2, "Zeleznicka 2", 100, kk2);
		ProfilKupca pk3 = new ProfilKupca(ko3, "Zeleznicka 3", 500, kk3);

		StanjeRacuna sr1 = StanjeRacuna.OTKAZANO;
		StanjeRacuna sr2 = StanjeRacuna.PORUCENO;
		StanjeRacuna sr3 = StanjeRacuna.USPESNO_REALIZOVANO;

		TipPopusta tp1 = TipPopusta.DODATNI;
		TipPopusta tp2 = TipPopusta.OSNOVNI;

		// Dodavanje kategorija artikala u akcijske dogadjaje
		ad1.addKategorijaArtiklaSaPopustima(ka1);
		ad1.addKategorijaArtiklaSaPopustima(ka4);
		ad1.addKategorijaArtiklaSaPopustima(ka5);

		ad2.addKategorijaArtiklaSaPopustima(ka1);
		ad2.addKategorijaArtiklaSaPopustima(ka4);
		ad2.addKategorijaArtiklaSaPopustima(ka5);

		ad3.addKategorijaArtiklaSaPopustima(ka1);
		ad3.addKategorijaArtiklaSaPopustima(ka4);
		ad3.addKategorijaArtiklaSaPopustima(ka5);

		ad4.addKategorijaArtiklaSaPopustima(ka1);
		ad4.addKategorijaArtiklaSaPopustima(ka4);
		ad4.addKategorijaArtiklaSaPopustima(ka5);

		ad5.addKategorijaArtiklaSaPopustima(ka2);

		ad6.addKategorijaArtiklaSaPopustima(ka3);

		// Punjenje baze

		addArtikal(ar1);
		addArtikal(ar2);
		addArtikal(ar3);
		addArtikal(ar4);
		addArtikal(ar5);
		addArtikal(ar6);
		addArtikal(ar7);
		addArtikal(ar8);
		addArtikal(ar9);
		addArtikal(ar10);
		addArtikal(ar11);
		addArtikal(ar12);
		addArtikal(ar13);
		addArtikal(ar14);
		addArtikal(ar15);
		addArtikal(ar16);

		addAkcijskiDogadjaj(ad1);
		addAkcijskiDogadjaj(ad2);
		addAkcijskiDogadjaj(ad3);
		addAkcijskiDogadjaj(ad4);
		addAkcijskiDogadjaj(ad5);
		addAkcijskiDogadjaj(ad6);

		addKategorijaArtikla(ka1);
		addKategorijaArtikla(ka2);
		addKategorijaArtikla(ka3);
		addKategorijaArtikla(ka4);
		addKategorijaArtikla(ka5);

		addKategorijaKupca(kk1);
		addKategorijaKupca(kk2);
		addKategorijaKupca(kk3);

		addKorisnik(ko1);
		addKorisnik(ko2);
		addKorisnik(ko3);
		addKorisnik(ko4);
		addKorisnik(ko5);
		addKorisnik(ko6);

		addUlogaKorisnika(uk1);
		addUlogaKorisnika(uk2);
		addUlogaKorisnika(uk3);

		addStanjeRacuna(sr1);
		addStanjeRacuna(sr2);
		addStanjeRacuna(sr3);

		addProfilKupca(pk1);
		addProfilKupca(pk2);
		addProfilKupca(pk3);

		addTipPopusta(tp1);
		addTipPopusta(tp2);

	}

	public void createFacts() throws JessException {

		int brojac = 0;
		for (AkcijskiDogadjaj ad : akcijskiDogadjaji) {
			engine.definstance("akcijskiDogadjaj" + brojac++, ad, false);
		}

		brojac = 0;
		for (Artikal a : artikli) {
			engine.definstance("artikal" + brojac++, a, false);
		}

		brojac = 0;
		for (KategorijaArtikla ka : kategorijeArtikla) {
			engine.definstance("kateogrijaArtikla" + brojac++, ka, false);
		}

		brojac = 0;
		for (KategorijaKupca kk : kategorijeKupca) {
			engine.definstance("kategorijeKupca" + brojac++, kk, false);
		}

		brojac = 0;
		for (Korisnik ko : korisnici) {
			engine.definstance("korisnik" + brojac++, ko, false);
		}

		brojac = 0;
		for (PragPotrosnje pp : pragoviPotrosnje) {
			engine.definstance("pragpotrosnje" + brojac++, pp, false);
		}

		brojac = 0;
		for (Racun ra : racuni) {
			engine.definstance("racun" + brojac++, ra, false);
		}

		brojac = 0;
		for (StavkaRacuna sr : stavkeRacuna) {
			engine.definstance("stavka" + brojac++, sr, false);
		}

		brojac = 0;
		for (ProfilKupca pk : profiliKupca) {
			engine.definstance("profilKupca" + brojac++, pk, false);
		}

		brojac = 0;
		for (Popust po : popustiZaRacun) {
			engine.definstance("popustiZaRacun" + brojac++, po, false);
		}

		brojac = 0;
		for (PopustZaPojedinacnuStavku ps : popustiZaStavku) {
			engine.definstance("popustiZaStavku" + brojac++, ps, false);
		}

	}

	/**
	 * Format je "dd/mm/yyyy"
	 * 
	 * @param s
	 * @return
	 */
	public Date parseDate(String s) {
		try {
			return (new SimpleDateFormat("dd/mm/yyyy")).parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	/*
	public void kreirajFakte(Racun r) {

		ProfilKupca pk = r.getKupac();
		KategorijaKupca kk = pk.getKategorijaKupca();
		PragPotrosnje pp = kk.getPragPotrosnje();
		Korisnik ko = pk.getKorisnik();

		ArrayList<Racun> prethodniRacuni = getAllRacuniByProfilKorisnika(pk);

		try {
			engine.definstance("profilKupca", pk, false);
			engine.definstance("kategorijaKupca", kk, false);
			engine.definstance("pragPotrosnje", pp, false);
			engine.definstance("korisnik", ko, false);

			int brojac = 0;
			for (Racun racun : prethodniRacuni) {
				engine.definstance("prethodniRacun" + brojac++, racun, false);
			}

		} catch (JessException e) {
			e.printStackTrace();
		}
	}
	*/
	/*
	public void pokupiFakte(String className) {

		List<Object> objekti = Rezoner.vratiRezultate(className);

		for (Object object : objekti) {
			if (object instanceof Artikal) {

			} else if (object instanceof AkcijskiDogadjaj) {

			} else if (object instanceof KategorijaArtikla) {

			}
		}

	}
	*/

	public ArrayList<Racun> getAllRacuniByProfilKorisnika(ProfilKupca pk) {
		ArrayList<Racun> retVal = new ArrayList<Racun>();
		for (Racun r : racuni) {
			if (r.getKupac().getKorisnik().getKorisnickoIme()
					.equals(pk.getKorisnik().getKorisnickoIme())) {
				retVal.add(r);
			}
		}
		return retVal;
	}

	public boolean addStavkaRacuna(StavkaRacuna sr) {
		for (StavkaRacuna s : stavkeRacuna) {
			if (s.getRacun().getSifra().equals(sr.getRacun().getSifra())
					&& sr.getRedniBrojStavke() == s.getRedniBrojStavke()) {
				System.out.println("Vec stavka racuna sa istom sifrom racuna i rednim brojem stavke");
				return false;
			}
		}
		stavkeRacuna.add(sr);
		return true;
	}

	public boolean addUlogaKorisnika(UlogaKorisnika uk) {
		for (UlogaKorisnika u : ulogeKorisnika) {
			if (u.equals(uk)) {
				System.out.println("Vec postoji ova uloga korisnika");
				return false;
			}
		}
		ulogeKorisnika.add(uk);
		return true;
	}

	public boolean addTipPopusta(TipPopusta tp) {
		for (TipPopusta t : tipoviPopusta) {
			if (t.equals(tp)) {
				System.out.println("Vec postoji ovaj tip popusta");
				return false;
			}
		}
		tipoviPopusta.add(tp);
		return true;
	}

	public boolean addStanjeRacuna(StanjeRacuna sr) {
		for (StanjeRacuna s : stanjaRacuna) {
			if (s.equals(sr)) {
				System.out.println("Vec postoji ovo stanje racuna");
				return false;
			}
		}
		stanjaRacuna.add(sr);
		return true;
	}

	public boolean addRacun(Racun ra) {
		for (Racun r : racuni) {
			if (r.getSifra().equals(ra.getSifra())) {
				System.out.println("Vec postoji racun sa ovom sifrom");
				return false;
			}
		}
		racuni.add(ra);
		return true;
	}

	public boolean addProfilKupca(ProfilKupca pk) {
		for (ProfilKupca p : profiliKupca) {
			if (p.getKorisnik().getKorisnickoIme()
					.equals(pk.getKorisnik().getKorisnickoIme())) {
				System.out.println("Vec postoji profil kupca koji ima ovog korisnika");
				return false;
			}
		}
		profiliKupca.add(pk);
		return true;
	}

	public boolean addPragPotrosnje(PragPotrosnje pr) {
		for (PragPotrosnje p : pragoviPotrosnje) {
			if (p.equals(pr)) {
				System.out.println("Vec postoji ovaj prag potrosnje");
				return false;
			}
		}
		pragoviPotrosnje.add(pr);
		return true;
	}

	public boolean addPopustZaStavku(PopustZaPojedinacnuStavku pp) {
		for (PopustZaPojedinacnuStavku p : popustiZaStavku) {
			if (p.getSifra().equals(pp.getSifra())) {
				System.out.println("Vec postoji popust za stavku sa ovom sifrom");
				return false;
			}
		}
		popustiZaStavku.add(pp);
		return true;
	}

	public boolean addPopustZaRacun(Popust pp) {
		for (Popust p : popustiZaRacun) {
			if (p.getSifra().equals(pp.getSifra())) {
				System.out.println("Vec postoji popust za racun sa ovom sifrom");
				return false;
			}
		}
		popustiZaRacun.add(pp);
		return true;
	}

	public boolean addKorisnik(Korisnik ko) {
		for (Korisnik k : korisnici) {
			if (k.getKorisnickoIme().equals(ko.getKorisnickoIme())) {
				System.out.println("Vec postoji korisnik sa ovim korisnickim imenom");
				return false;
			}
		}
		korisnici.add(ko);
		return true;
	}

	public Korisnik korisnikExists(Korisnik ko) {
		for (Korisnik k : korisnici) {
			if (k.getKorisnickoIme().equals(ko.getKorisnickoIme())) {
				return k;
			}
		}
		return null;
	}

	public boolean addKategorijaKupca(KategorijaKupca kk) {
		for (KategorijaKupca k : kategorijeKupca) {
			if (k.getSifraKategorije().equals(kk.getSifraKategorije())) {
				System.out.println("Vec postoji kategorija kupca sa ovom sifrom kategorije");
				return false;
			}
		}
		kategorijeKupca.add(kk);
		return true;
	}

	public boolean addAkcijskiDogadjaj(AkcijskiDogadjaj ad) {
		for (AkcijskiDogadjaj a : akcijskiDogadjaji) {
			if (a.getSifra().equals(ad.getSifra())) {
				System.out.println("Vec postoji popust sa ovom sifrom akcijskog dogadjaja");
				return false;
			}
		}
		akcijskiDogadjaji.add(ad);
		return true;
	}

	public boolean addArtikal(Artikal ar) {
		for (Artikal a : artikli) {
			if (a.getSifra().equals(ar.getSifra())) {
				System.out.println("Vec postoji artikal sa ovom sifrom");
				return false;
			}
		}
		artikli.add(ar);
		return true;
	}

	public boolean addKategorijaArtikla(KategorijaArtikla ka) {
		for (KategorijaArtikla k : kategorijeArtikla) {
			if (k.getSifraKategorije().equals(ka.getSifraKategorije())) {
				System.out.println("Vec postoji kategorija artikla sa ovom sifrom kategorije artikla");
				return false;
			}
		}
		kategorijeArtikla.add(ka);
		return true;
	}

	public ArrayList<Artikal> getAllArtikliByKategorija(KategorijaArtikla ka) {
		
		ArrayList<Artikal> retVal = new ArrayList<Artikal>();
		for (Artikal artikal : artikli) {
			if (artikal.getKategorijaArtikla().getNaziv().equals(ka.getNaziv())
					|| (artikal.getKategorijaArtikla().getNadkategorija() != null && artikal.getKategorijaArtikla().getNadkategorija().getNaziv().equals(ka.getNaziv()))) {
				retVal.add(artikal);
			}
		}
		
		return retVal;
	}
	
	//GETTERS BY ATTRIBUTE
	
	public Korisnik getKorisnikByKorisnickoIme(String username){
		for (Korisnik ko : korisnici) {
			if (ko.getKorisnickoIme().equals(username)){
				return ko;
			}
		}
		return null;
	}
	
	public ProfilKupca getProfilKupcaByKorisnickoIme(String username){
		for (ProfilKupca pk	: profiliKupca) {
			if (pk.getKorisnik().getKorisnickoIme().equals(username)){
				return pk;
			}
		}
		return null;
	}

	// GETTERS BY ATTRIBUTE
	public ArrayList<StavkaRacuna> getStavkeRacuna() {
		return stavkeRacuna;
	}

	public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
		this.stavkeRacuna = stavkeRacuna;
	}

	public ArrayList<AkcijskiDogadjaj> getAkcijskiDogadjaji() {
		return akcijskiDogadjaji;
	}

	public void setAkcijskiDogadjaji(
			ArrayList<AkcijskiDogadjaj> akcijskiDogadjaji) {
		this.akcijskiDogadjaji = akcijskiDogadjaji;
	}

	public ArrayList<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(ArrayList<Artikal> artikli) {
		this.artikli = artikli;
	}

	public ArrayList<KategorijaArtikla> getKategorijeArtikla() {
		return kategorijeArtikla;
	}

	public void setKategorijeArtikla(
			ArrayList<KategorijaArtikla> kategorijeArtikla) {
		this.kategorijeArtikla = kategorijeArtikla;
	}

	public ArrayList<KategorijaKupca> getKategorijeKupca() {
		return kategorijeKupca;
	}

	public void setKategorijeKupca(ArrayList<KategorijaKupca> kategorijeKupca) {
		this.kategorijeKupca = kategorijeKupca;
	}

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public ArrayList<Popust> getPopustiZaRacun() {
		return popustiZaRacun;
	}

	public void setPopustiZaRacun(ArrayList<Popust> popustiZaRacun) {
		this.popustiZaRacun = popustiZaRacun;
	}

	public ArrayList<PopustZaPojedinacnuStavku> getPopustiZaStavku() {
		return popustiZaStavku;
	}

	public void setPopustiZaStavku(
			ArrayList<PopustZaPojedinacnuStavku> popustiZaStavku) {
		this.popustiZaStavku = popustiZaStavku;
	}

	public ArrayList<PragPotrosnje> getPragoviPotrosnje() {
		return pragoviPotrosnje;
	}

	public void setPragoviPotrosnje(ArrayList<PragPotrosnje> pragoviPotrosnje) {
		this.pragoviPotrosnje = pragoviPotrosnje;
	}

	public ArrayList<ProfilKupca> getProfiliKupca() {
		return profiliKupca;
	}

	public void setProfiliKupca(ArrayList<ProfilKupca> profiliKupca) {
		this.profiliKupca = profiliKupca;
	}

	public ArrayList<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(ArrayList<Racun> racuni) {
		this.racuni = racuni;
	}

	public ArrayList<StanjeRacuna> getStanjaRacuna() {
		return stanjaRacuna;
	}

	public void setStanjaRacuna(ArrayList<StanjeRacuna> stanjaRacuna) {
		this.stanjaRacuna = stanjaRacuna;
	}

	public ArrayList<TipPopusta> getTipoviPopusta() {
		return tipoviPopusta;
	}

	public void setTipoviPopusta(ArrayList<TipPopusta> tipoviPopusta) {
		this.tipoviPopusta = tipoviPopusta;
	}

	public ArrayList<UlogaKorisnika> getUlogeKorisnika() {
		return ulogeKorisnika;
	}

	public void setUlogeKorisnika(ArrayList<UlogaKorisnika> ulogeKorisnika) {
		this.ulogeKorisnika = ulogeKorisnika;
	}

}