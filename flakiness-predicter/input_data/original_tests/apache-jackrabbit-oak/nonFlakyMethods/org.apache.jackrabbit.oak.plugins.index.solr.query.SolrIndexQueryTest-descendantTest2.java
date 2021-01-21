@Test public void descendantTest2() throws Exception {
  Tree test=root.getTree("/").addChild("test");
  test.addChild("a").addChild("c").setProperty("name",asList("Hello","World"),STRINGS);
  test.addChild("b").setProperty("name","Hello");
  root.commit();
  Iterator<String> result=executeQuery("select [jcr:path] from [nt:base] where isdescendantnode('/test') and name='World'","JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/a/c",result.next());
  assertFalse(result.hasNext());
}
