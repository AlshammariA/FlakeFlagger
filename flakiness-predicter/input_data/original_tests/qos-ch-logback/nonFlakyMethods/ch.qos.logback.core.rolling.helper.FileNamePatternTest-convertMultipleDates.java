@Test public void convertMultipleDates(){
  Calendar cal=Calendar.getInstance();
  cal.set(2003,4,20,17,55);
  FileNamePattern fnp=new FileNamePattern("foo-%d{yyyy.MM, aux}/%d{yyyy.MM.dd}.txt",context);
  assertEquals("foo-2003.05/2003.05.20.txt",fnp.convert(cal.getTime()));
}
