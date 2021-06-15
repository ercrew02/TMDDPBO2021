package presenter;

public class DataTabel {
	// membuat class publik untuk proses data tabel
	private ProsesPlayer prosesPlayer;

	public DataTabel() {
		// kontainer
		prosesPlayer = new ProsesPlayer();
		// membuat ProsesPengguna
	}

	public String[][] getData() {
		// mengambil data pengguna
		String datatamp[][] = new String[100][100];
		try {
			prosesPlayer.dataPlayer();
			for (int i = 0; i < prosesPlayer.getSize(); i++) {
				datatamp[i][0] = prosesPlayer.getNama(i);
				datatamp[i][1] = prosesPlayer.getFail(i);
				datatamp[i][2] = prosesPlayer.getSuccess(i);
				// memindahkan data Player dari database(nama, sukses, dan fail)
			}
		} catch (Exception e) {
			System.out.println(prosesPlayer.getError());
		}
		return datatamp;
		// mengembalikan datatamp
	}
}