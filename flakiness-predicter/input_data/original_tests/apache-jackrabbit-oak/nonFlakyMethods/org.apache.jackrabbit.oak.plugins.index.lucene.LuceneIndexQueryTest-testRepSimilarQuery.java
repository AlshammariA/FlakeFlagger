@Test public void testRepSimilarQuery() throws Exception {
  String query="select [jcr:path] from [nt:base] where similar(., '/test/a')";
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
  Iterator<String> result=executeQuery(query,"JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/b",result.next());
  assertTrue(result.hasNext());
}
