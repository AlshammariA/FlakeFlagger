@Test public void testNativeSolrQuery() throws Exception {
  String nativeQueryString="select [jcr:path] from [nt:base] where native('solr', 'name:(Hello OR World)')";
  Tree tree=root.getTree("/");
  Tree test=tree.addChild("test");
  test.addChild("a").setProperty("name","Hello");
  test.addChild("b").setProperty("name","World");
  test.addChild("c");
  root.commit();
  Iterator<String> strings=executeQuery(nativeQueryString,"JCR-SQL2").iterator();
  assertTrue(strings.hasNext());
  assertEquals("/test/a",strings.next());
  assertTrue(strings.hasNext());
  assertEquals("/test/b",strings.next());
  assertFalse(strings.hasNext());
}
