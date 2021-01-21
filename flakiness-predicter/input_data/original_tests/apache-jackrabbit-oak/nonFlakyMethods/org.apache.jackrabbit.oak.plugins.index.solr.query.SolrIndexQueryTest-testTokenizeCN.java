@Test public void testTokenizeCN() throws Exception {
  Tree t=root.getTree("/").addChild("containsCN");
  Tree one=t.addChild("one");
  one.setProperty("t","美女衬衫");
  root.commit();
  assertQuery("//*[jcr:contains(., '美女')]","xpath",ImmutableList.of(one.getPath()));
}
