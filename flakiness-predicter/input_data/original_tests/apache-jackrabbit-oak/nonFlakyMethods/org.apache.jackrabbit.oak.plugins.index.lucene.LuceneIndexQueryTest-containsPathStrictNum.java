@Test public void containsPathStrictNum() throws Exception {
  root.getTree("/").addChild("matchOnPath1234");
  root.getTree("/").addChild("match_on_path1234");
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("//*[jcr:contains(., 'match')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/match_on_path1234"));
}
