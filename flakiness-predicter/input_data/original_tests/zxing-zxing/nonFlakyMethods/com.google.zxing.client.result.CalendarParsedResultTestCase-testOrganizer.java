@Test public void testOrganizer(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "ORGANIZER:mailto:bob@example.org\r\n"+ "END:VEVENT\r\nEND:VCALENDAR",null,null,null,"20080504T123456Z",null,"bob@example.org",null,Double.NaN,Double.NaN);
}
