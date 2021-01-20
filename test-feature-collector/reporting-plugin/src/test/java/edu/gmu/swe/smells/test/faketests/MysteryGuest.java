package edu.gmu.swe.smells.test.faketests;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import edu.gmu.swe.smells.test.fakeproduction.IndirectlyMysteryGuest;
public class MysteryGuest {
	public void testMysteryGuestFileIndirectly() throws InterruptedException, IOException {
		IndirectlyMysteryGuest.mysteryGuestFile();
	}

	public void testMysteryGuestFileDirectly() throws InterruptedException, IOException {
		File test = File.createTempFile("image", "png", new File("/temp"));
	}

	public void testMysteryGuestDatabaseIndirectly() throws InterruptedException, SQLException {
		IndirectlyMysteryGuest.mysteryGuestDatabase();
	}

	public void testMysteryGuestDatabaseDirectly() throws InterruptedException, SQLException {
		Connection testConnection = DriverManager.getConnection("url","testUser","testPass");
	}

	public void testMysteryGuestConstructors(){
		File test = new File("/temp");
	}
	/*
	public void testMysteryGuestNetworkIndirectly() throws InterruptedException, SQLException, UnknownHostException, IOException {
		IndirectlyMysteryGuest.mysteryGuestNetwork();
	}

	public void testMysteryGuestNetworkDirectly() throws InterruptedException, UnknownHostException, IOException {
		Socket server = new Socket("IP", 5000);
	}
	*/
}
