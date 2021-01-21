@Test public void testNativeLuceneQuery() throws Exception {
  String nativeQueryString="select [jcr:path] from [nt:base] where native('lucene', 'title:foo -title:bar')";
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").setProperty("title","foo");
  test.addChild("b").setProperty("title","bar");
  root.commit();
  Iterator<String> result=executeQuery(nativeQueryString,"JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertFalse(result.hasNext());
}
