package presenter;

import java.util.ArrayList;
import model.*;
//import

public class ProsesPlayer implements PlayerPresenter {
	// membuat public class proses pengguna implementasi dari PenggunaPresenter
	private String error;
	private ResultPengguna resultPengguna;
	private ArrayList<Pengguna> data;
	// membuat private variabel

	public ProsesPlayer() {
		try {
		} catch (Exception e) {
			System.out.println(e);
			error = e.toString();
		}
	}

	public void dataPlayer() {
		// kontainer
		try {
			resultPengguna = new ResultPengguna();
			data = new ArrayList<Pengguna>();
			resultPengguna.getPengguna();
			while (resultPengguna.getResult().next()) {
				String id = resultPengguna.getResult().getString(1);
				String username = resultPengguna.getResult().getString(2);
				String scoreFail = resultPengguna.getResult().getString(3);
				String scoreSuccess = resultPengguna.getResult().getString(4);
				Pengguna pengguna = new Pengguna(id, username, scoreFail, scoreSuccess);
				data.add(pengguna);
			}
			resultPengguna.closeResult();
			resultPengguna.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
			error = e.toString();
		}
	}

	public String getID(int i) {
		return data.get(i).id;
	}

	public String getNama(int i) {
		return data.get(i).nama;
	}

	public String getFail(int i) {
		return data.get(i).fail;
	}

	public String getSuccess(int i) {
		return data.get(i).success;
	}

	public int getSize() {
		return data.size();
	}

	public String getError() {
		return this.error;
	}
}