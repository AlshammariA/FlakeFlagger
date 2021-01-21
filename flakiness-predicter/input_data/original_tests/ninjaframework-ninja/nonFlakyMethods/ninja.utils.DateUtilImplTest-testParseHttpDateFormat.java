@Test public void testParseHttpDateFormat() throws Exception {
  assertEquals(new Date(0L).toString(),DateUtil.parseHttpDateFormat("Thu, 01 Jan 1970 00:00:00 GMT").toString());
  assertEquals(new Date(1346839077523L).toString(),DateUtil.parseHttpDateFormat("Wed, 05 Sep 2012 09:57:57 GMT").toString());
}
