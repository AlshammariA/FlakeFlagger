@Test public void contains() throws Exception {
  String h="Hello" + System.currentTimeMillis();
  String w="World" + System.currentTimeMillis();
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("name",asList(h,w),STRINGS);
  test.addChild("b").setProperty("name",h);
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("/jcr:root//*[jcr:contains(., '").append(h);
  stmt.append("')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/test/a","/test/b"));
  stmt=new StringBuffer();
  stmt.append("/jcr:root//*[jcr:contains(., '").append(w);
  stmt.append("')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/test/a"));
}
