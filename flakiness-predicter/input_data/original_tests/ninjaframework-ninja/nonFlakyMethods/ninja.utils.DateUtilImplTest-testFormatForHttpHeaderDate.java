@Test public void testFormatForHttpHeaderDate(){
  assertEquals("Thu, 01 Jan 1970 00:00:00 GMT",DateUtil.formatForHttpHeader(new Date(0L)));
  assertEquals("Wed, 05 Sep 2012 09:57:57 GMT",DateUtil.formatForHttpHeader(new Date(1346839077523L)));
}
