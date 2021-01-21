@Test public void testNativeSolrFunctionQuery() throws Exception {
  String nativeQueryString="select [jcr:path] from [nt:base] where native('solr', 'path_child:\\/test  _val_:\"recip(rord(name),1,2,3)\"')";
  Tree tree=root.getTree("/");
  Tree test=tree.addChild("test");
  test.addChild("a").setProperty("name","Hello");
  test.addChild("b").setProperty("name","World");
  tree.addChild("c");
  root.commit();
  Iterator<String> strings=executeQuery(nativeQueryString,"JCR-SQL2").iterator();
  assertTrue(strings.hasNext());
  assertEquals("/test/a",strings.next());
  assertTrue(strings.hasNext());
  assertEquals("/test/b",strings.next());
  assertFalse(strings.hasNext());
}
