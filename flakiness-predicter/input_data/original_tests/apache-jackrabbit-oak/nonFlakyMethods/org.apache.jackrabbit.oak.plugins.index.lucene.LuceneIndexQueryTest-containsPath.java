@Test public void containsPath() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("name","/parent/child/node");
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("//*[jcr:contains(., '/parent/child')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/test/a"));
}
