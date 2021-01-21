@Test public void asRegexByDate(){
  Calendar cal=Calendar.getInstance();
  cal.set(2003,4,20,17,55);
{
    FileNamePattern fnp=new FileNamePattern("foo-%d{yyyy.MM.dd}-%i.txt",context);
    String regex=fnp.toRegexForFixedDate(cal.getTime());
    assertEquals("foo-2003.05.20-(\\d{1,3}).txt",regex);
  }
{
    FileNamePattern fnp=new FileNamePattern("\\toto\\foo-%d{yyyy\\MM\\dd}-%i.txt",context);
    String regex=fnp.toRegexForFixedDate(cal.getTime());
    assertEquals("/toto/foo-2003/05/20-(\\d{1,3}).txt",regex);
  }
}
