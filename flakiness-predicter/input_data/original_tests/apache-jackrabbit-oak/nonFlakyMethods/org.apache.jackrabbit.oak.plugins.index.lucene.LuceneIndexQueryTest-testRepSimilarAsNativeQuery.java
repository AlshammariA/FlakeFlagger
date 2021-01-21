@Test public void testRepSimilarAsNativeQuery() throws Exception {
  String nativeQueryString="select [jcr:path] from [nt:base] where " + "native('lucene', 'mlt?stream.body=/test/a&mlt.fl=:path&mlt.mindf=0&mlt.mintf=0')";
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("text","Hello World");
  test.addChild("b").setProperty("text","He said Hello and then the world said Hello as well.");
  test.addChild("c").setProperty("text","He said Hi.");
  root.commit();
  Iterator<String> result=executeQuery(nativeQueryString,"JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/b",result.next());
  assertFalse(result.hasNext());
}
