@Test public void testSummary(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "SUMMARY:foo\r\n" + "DTSTART:20080504T123456Z\r\n"+ "END:VEVENT\r\nEND:VCALENDAR",null,"foo",null,"20080504T123456Z",null);
}
