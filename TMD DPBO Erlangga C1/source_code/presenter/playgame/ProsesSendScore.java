package presenter.playgame;

import model.*;

public class ProsesSendScore {
	// class proses pengiriman score
	ResultPengguna pengguna;

	public ProsesSendScore() {
		// kontainer
		try {
			pengguna = new ResultPengguna();
			// panggil kelas resultpengguna
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void send(String nama, Score score) {
		// method kirim nama dan score ke class result pengguna
		try {
			String success = score.getSuccess();
			String fail = score.getFail();
			pengguna.insertPengguna(nama, success, fail);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}