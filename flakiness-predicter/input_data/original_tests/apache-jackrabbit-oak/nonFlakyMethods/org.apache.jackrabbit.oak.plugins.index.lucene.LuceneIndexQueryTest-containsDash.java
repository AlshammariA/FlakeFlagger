@Test public void containsDash() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("name","hello-wor");
  test.addChild("b").setProperty("name","hello-world");
  test.addChild("c").setProperty("name","hello");
  root.commit();
  assertQuery("/jcr:root//*[jcr:contains(., 'hello-wor*')]","xpath",ImmutableList.of("/test/a","/test/b"));
  assertQuery("/jcr:root//*[jcr:contains(., '*hello-wor*')]","xpath",ImmutableList.of("/test/a","/test/b"));
}
