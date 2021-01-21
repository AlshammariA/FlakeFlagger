@Test public void testCompositeRepExcerpt() throws Exception {
  String sqlQuery="select [jcr:path], [jcr:score], [rep:excerpt] from [nt:base] as a " + "where (contains([jcr:content/*], 'square') or contains([jcr:content/jcr:title], 'square')" + " or contains([jcr:content/jcr:description], 'square')) and isdescendantnode(a, '/test') "+ "order by [jcr:score] desc";
  Tree tree=root.getTree("/");
  Tree test=tree.addChild("test");
  Tree child=test.addChild("child");
  Tree a=child.addChild("a");
  a.setProperty("jcr:title","Hello World, today square is nice");
  Tree b=child.addChild("b");
  b.setProperty("jcr:description","Cheers World, today weather is squary nice");
  Tree c=child.addChild("c");
  c.setProperty("jcr:title","Halo Welt, today sky is square");
  root.commit();
  Iterator<String> strings=executeQuery(sqlQuery,"JCR-SQL2").iterator();
  assertTrue(strings.hasNext());
  assertTrue(strings.next().startsWith("/test/child,"));
  assertFalse(strings.hasNext());
}
