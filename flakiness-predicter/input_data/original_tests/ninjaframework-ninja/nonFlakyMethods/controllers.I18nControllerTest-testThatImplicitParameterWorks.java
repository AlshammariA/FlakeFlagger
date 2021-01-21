@Test public void testThatImplicitParameterWorks(){
  Map<String,String> headers=Maps.newHashMap();
  headers.put("Accept-Language","de-DE");
  String result=ninjaTestBrowser.makeRequest(getServerAddress() + "/i18n",headers);
  assertTrue(result.contains("Implicit language is: de-DE"));
}
