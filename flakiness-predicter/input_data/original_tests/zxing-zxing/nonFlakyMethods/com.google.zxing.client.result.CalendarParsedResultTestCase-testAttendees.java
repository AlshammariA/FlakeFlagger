@Test public void testAttendees(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "ATTENDEE:mailto:bob@example.org\r\n"+ "ATTENDEE:mailto:alice@example.org\r\n"+ "END:VEVENT\r\nEND:VCALENDAR",null,null,null,"20080504T123456Z",null,null,new String[]{"bob@example.org","alice@example.org"},Double.NaN,Double.NaN);
}
