@Test public void testFullTextTermName() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("testFullTextTermNameSimple");
  c.addChild("testFullTextTermNameFile.txt");
  root.commit();
  assertQuery("//*[jcr:contains(., 'testFullTextTermNameSimple')]","xpath",ImmutableList.of("/content/testFullTextTermNameSimple"));
  assertQuery("//*[jcr:contains(., 'testFullTextTermNameFile.txt')]","xpath",ImmutableList.of("/content/testFullTextTermNameFile.txt"));
}
