@Test public void testStart(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "END:VEVENT\r\nEND:VCALENDAR",null,null,null,"20080504T123456Z",null);
}
