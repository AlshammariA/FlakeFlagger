@Test public void multiPhraseQuery() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("dc:format","type:application/pdf");
  root.commit();
  assertQuery("/jcr:root//*[jcr:contains(@dc:format, 'type:appli*')]","xpath",ImmutableList.of("/test/a"));
}
