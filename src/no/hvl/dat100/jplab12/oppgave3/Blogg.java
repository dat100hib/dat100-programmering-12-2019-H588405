package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {
	// TODO: objektvariable
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		Innlegg[] ny = innleggtabell;
		return ny;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) < 0) {
			return false;
		}
		return true;
	}

	public boolean ledigPlass() {
		if (nesteledig < innleggtabell.length) {
			return true;
		}
		return false;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		String antall = getAntall() + "\n";
		for (int i = 0; i < innleggtabell.length; i++) {
			antall += innleggtabell[i].toString();
		}
		return antall;
	}
	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] ny = innleggtabell.clone();
		innleggtabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			innleggtabell[i] = ny[i];
		}
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
				leggTil(innlegg);
				return true;
			}
			if (ledigPlass()) {
				leggTil(innlegg);
				return true;
			}
		}
		return false;
	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());
	}
}