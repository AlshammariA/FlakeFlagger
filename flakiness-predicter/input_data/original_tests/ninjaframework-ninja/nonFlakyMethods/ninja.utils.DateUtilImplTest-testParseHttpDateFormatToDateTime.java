@Test public void testParseHttpDateFormatToDateTime() throws Exception {
  assertEquals(new DateTime(0L).toDate().toString(),DateUtil.parseHttpDateFormatToDateTime("Thu, 01 Jan 1970 00:00:00 GMT").toDate().toString());
  assertEquals(new DateTime(1346839077523L).toDate().toString(),DateUtil.parseHttpDateFormatToDateTime("Wed, 05 Sep 2012 09:57:57 GMT").toDate().toString());
}
