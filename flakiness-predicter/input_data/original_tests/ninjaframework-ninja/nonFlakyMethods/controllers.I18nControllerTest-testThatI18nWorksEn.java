@Test public void testThatI18nWorksEn(){
  Map<String,String> headers=Maps.newHashMap();
  headers.put("Accept-Language","en-US");
  String result=ninjaTestBrowser.makeRequest(getServerAddress() + "/i18n",headers);
  assertTrue(result.contains(TEXT_EN));
}
