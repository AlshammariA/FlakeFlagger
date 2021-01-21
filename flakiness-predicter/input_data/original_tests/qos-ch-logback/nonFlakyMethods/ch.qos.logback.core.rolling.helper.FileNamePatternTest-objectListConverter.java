@Test public void objectListConverter(){
  Calendar cal=Calendar.getInstance();
  cal.set(2003,4,20,17,55);
  FileNamePattern fnp=new FileNamePattern("foo-%d{yyyy.MM.dd}-%i.txt",context);
  assertEquals("foo-2003.05.20-79.txt",fnp.convertMultipleArguments(cal.getTime(),79));
}
