@Test public void testLocation(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "LOCATION:Miami\r\n" + "DTSTART:20080504T123456Z\r\n"+ "END:VEVENT\r\nEND:VCALENDAR",null,null,"Miami","20080504T123456Z",null);
}
