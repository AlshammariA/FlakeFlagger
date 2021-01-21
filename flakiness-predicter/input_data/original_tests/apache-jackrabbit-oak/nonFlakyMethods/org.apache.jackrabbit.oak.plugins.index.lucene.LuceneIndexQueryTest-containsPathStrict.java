@Test public void containsPathStrict() throws Exception {
  root.getTree("/").addChild("matchOnPath");
  root.getTree("/").addChild("match_on_path");
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("//*[jcr:contains(., 'match')]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of("/match_on_path"));
}
