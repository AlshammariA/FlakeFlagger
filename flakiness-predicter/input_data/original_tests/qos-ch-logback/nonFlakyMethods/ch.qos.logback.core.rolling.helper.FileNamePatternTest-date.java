@Test public void date(){
  Calendar cal=Calendar.getInstance();
  cal.set(2003,4,20,17,55);
  FileNamePattern pp=new FileNamePattern("foo%d{yyyy.MM.dd}",context);
  assertEquals("foo2003.05.20",pp.convert(cal.getTime()));
  pp=new FileNamePattern("foo%d{yyyy.MM.dd HH:mm}",context);
  assertEquals("foo2003.05.20 17:55",pp.convert(cal.getTime()));
  pp=new FileNamePattern("%d{yyyy.MM.dd HH:mm} foo",context);
  assertEquals("2003.05.20 17:55 foo",pp.convert(cal.getTime()));
}
