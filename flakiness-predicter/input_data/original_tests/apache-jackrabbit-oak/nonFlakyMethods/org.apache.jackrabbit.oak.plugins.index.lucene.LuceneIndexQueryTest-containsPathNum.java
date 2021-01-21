@Test public void containsPathNum() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  Tree a=test.addChild("a");
  a.setProperty("name","/segment1/segment2/segment3");
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("//*[jcr:contains(., '/segment1/segment2')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/test/a"));
}
