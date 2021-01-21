@Test public void testNativeSolrLocalParams() throws Exception {
  String nativeQueryString="select [jcr:path] from [nt:base] where native('solr', '_query_:\"{!dismax qf=catch_all q.op=OR}hello world\"')";
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
