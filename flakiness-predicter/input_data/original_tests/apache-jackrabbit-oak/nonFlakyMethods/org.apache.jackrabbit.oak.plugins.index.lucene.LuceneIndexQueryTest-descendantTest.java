@Test public void descendantTest() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a");
  test.addChild("b");
  root.commit();
  Iterator<String> result=executeQuery("select [jcr:path] from [nt:base] where isdescendantnode('/test')","JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a",result.next());
  assertEquals("/test/b",result.next());
  assertFalse(result.hasNext());
}
