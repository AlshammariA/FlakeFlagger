@Test public void testFormatForHttpHeaderLong(){
  assertEquals("Thu, 01 Jan 1970 00:00:00 GMT",DateUtil.formatForHttpHeader(0L));
  assertEquals("Wed, 05 Sep 2012 09:57:57 GMT",DateUtil.formatForHttpHeader(1346839077523L));
}
