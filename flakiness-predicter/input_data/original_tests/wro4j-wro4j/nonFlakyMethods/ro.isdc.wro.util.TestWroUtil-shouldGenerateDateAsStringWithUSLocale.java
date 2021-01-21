@Test public void shouldGenerateDateAsStringWithUSLocale(){
  Locale.setDefault(Locale.ITALY);
  final long milliseconds=1360278459808l;
  assertEquals("Thu, 07 Feb 2013 23:07:39 GMT",WroUtil.toDateAsString(milliseconds));
}
