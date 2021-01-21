@Test public void testFullTextTerm() throws Exception {
  Tree node=root.getTree("/").addChild("content");
  node.setProperty("jcr:mimeType","text/plain");
  root.commit();
  assertQuery("//*[jcr:contains(., 'text/plain')]","xpath",ImmutableList.of("/content"));
}
