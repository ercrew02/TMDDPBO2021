package presenter.playgame;

public class Score {
	public int success;
	public int fail;
	// membuat variabel public

	public Score() {
		success = 0;
		fail = 0;
	}

	public void tambahScore() {
		// menambah score sukses
		success++;
	}

	public void tambahFail() {
		// menambah score gagal
		fail++;
	}

	public String getSuccess() {

		return Integer.toString(success);
		// mengembalikan nilai sukses
	}

	public String getFail() {
		return Integer.toString(fail);
		// mengembalikan nilai fail
	}

}