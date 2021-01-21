@Test public void findHighestCounterTest() throws ParseException {
  String[] sa=new String[]{"c:/log/debug-old-2010-08-10.0.log","c:/log/debug-old-2010-08-10.1.log","c:/log/debug-old-2010-08-10.10.log","c:/log/debug-old-2010-08-10.11.log","c:/log/debug-old-2010-08-10.12.log","c:/log/debug-old-2010-08-10.2.log","c:/log/debug-old-2010-08-10.3.log","c:/log/debug-old-2010-08-10.4.log","c:/log/debug-old-2010-08-10.5.log","c:/log/debug-old-2010-08-10.6.log","c:/log/debug-old-2010-08-10.7.log","c:/log/debug-old-2010-08-10.8.log","c:/log/debug-old-2010-08-10.9.log"};
  File[] matchingFileArray=new File[sa.length];
  for (int i=0; i < sa.length; i++) {
    matchingFileArray[i]=new File(sa[i]);
  }
  FileNamePattern fnp=new FileNamePattern("c:/log/debug-old-%d{yyyy-MM-dd}.%i.log",context);
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  String rexexp=null;
  rexexp=fnp.toRegexForFixedDate(sdf.parse("2010-08-10"));
  String stemRegex=FileFilterUtil.afterLastSlash(rexexp);
  int result=FileFilterUtil.findHighestCounter(matchingFileArray,stemRegex);
  assertEquals(12,result);
}
