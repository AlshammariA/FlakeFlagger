/** 
 * Test for OAK-841
 */
@Test public void emptyStringValue() throws CommitFailedException {
  Tree t=root.getTree("/");
  t.addChild("node-1").setProperty("pid","value");
  root.commit();
  t=root.getTree("/");
  t.addChild("node-2").setProperty("pid","");
  root.commit();
  t=root.getTree("/");
  t.addChild("node-3").setProperty("pid",":");
  root.commit();
  setTravesalEnabled(false);
  assertQuery("select [jcr:path] from [nt:base] where [pid] = 'value'",ImmutableList.of("/node-1"));
  assertQuery("select [jcr:path] from [nt:base] where [pid] = ''",ImmutableList.of("/node-2"));
  assertQuery("select [jcr:path] from [nt:base] where [pid] = ':'",ImmutableList.of("/node-3"));
  setTravesalEnabled(true);
}
