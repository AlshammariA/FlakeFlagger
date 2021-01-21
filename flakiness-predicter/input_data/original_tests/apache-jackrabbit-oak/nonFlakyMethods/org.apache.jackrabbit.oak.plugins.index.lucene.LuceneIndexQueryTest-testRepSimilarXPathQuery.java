@Test public void testRepSimilarXPathQuery() throws Exception {
  String query="//element(*, nt:base)[rep:similar(., '/test/a')]";
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("text","Hello World Hello World");
  test.addChild("b").setProperty("text","Hello World");
  test.addChild("c").setProperty("text","World");
  test.addChild("d").setProperty("text","Hello");
  test.addChild("e").setProperty("text","World");
  test.addChild("f").setProperty("text","Hello");
  test.addChild("g").setProperty("text","World");
  test.addChild("h").setProperty("text","Hello");
  root.commit();
  Iterator<String> result=executeQuery(query,"xpath").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/b",result.next());
}
