package edu.gmu.swe.smells.test.fakeproduction;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class IndirectlyMysteryGuest {
	public static void mysteryGuestFile() throws InterruptedException, IOException {
		File test = File.createTempFile("image", "png", new File("/temp"));
	}
	
	public static void mysteryGuestDatabase() throws InterruptedException, SQLException {
		Connection testConnection = DriverManager.getConnection("url","testUser","testPass");
	}
	/*
	public static void mysteryGuestNetwork() throws InterruptedException, UnknownHostException, IOException {
		Socket server = new Socket("IP", 5000);
	}*/
}
