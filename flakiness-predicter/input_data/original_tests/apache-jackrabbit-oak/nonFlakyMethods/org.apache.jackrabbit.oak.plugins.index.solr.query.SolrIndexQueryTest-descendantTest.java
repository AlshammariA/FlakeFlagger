@Test public void descendantTest() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").addChild("c");
  test.addChild("b").addChild("d");
  root.commit();
  Iterator<String> result=executeQuery("select [jcr:path] from [nt:base] where isdescendantnode('/test')","JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/a/c",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/b",result.next());
  assertTrue(result.hasNext());
  assertEquals("/test/b/d",result.next());
  assertFalse(result.hasNext());
}
