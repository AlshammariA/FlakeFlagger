@Test public void testDescription(){
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "DESCRIPTION:This is a test\r\n"+ "END:VEVENT\r\nEND:VCALENDAR","This is a test",null,null,"20080504T123456Z",null);
  doTest("BEGIN:VCALENDAR\r\nBEGIN:VEVENT\r\n" + "DTSTART:20080504T123456Z\r\n" + "DESCRIPTION:This is a test\r\n\t with a continuation\r\n"+ "END:VEVENT\r\nEND:VCALENDAR","This is a test with a continuation",null,null,"20080504T123456Z",null);
}
