@Test public void testGeo(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "GEO:-12.345;-45.678\r\n"+ "END:VEVENT\r\nEND:VCALENDAR",null,null,null,"20080504T123456Z",null,null,null,-12.345,-45.678);
}
