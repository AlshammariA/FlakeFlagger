@Test public void ischildnodeTest2() throws Exception {
  Tree tree=root.getTree("/");
  Tree test=tree.addChild("test");
  test.addChild("jcr:resource").addChild("x");
  test.addChild("resource");
  root.commit();
  Iterator<String> strings=executeQuery("select [jcr:path] from [nt:base] as b where ischildnode(b, '/test')","JCR-SQL2").iterator();
  assertTrue(strings.hasNext());
  assertEquals("/test/jcr:resource",strings.next());
  assertTrue(strings.hasNext());
  assertEquals("/test/resource",strings.next());
  assertFalse(strings.hasNext());
}
