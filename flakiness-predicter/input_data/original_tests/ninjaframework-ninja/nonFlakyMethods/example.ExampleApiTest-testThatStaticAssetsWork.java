@Test public void testThatStaticAssetsWork(){
  String apiCallResult=ninjaTestBrowser.makeJsonRequest(getServerAddress() + "api/person.json");
  assertTrue(apiCallResult.startsWith("{\"name\":\"zeeess name -"));
}
