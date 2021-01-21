@Test public void ischildnodeTest() throws Exception {
  Tree tree=root.getTree("/");
  Tree parents=tree.addChild("parents");
  parents.addChild("p0").setProperty("id","0");
  parents.addChild("p1").setProperty("id","1");
  parents.addChild("p2").setProperty("id","2");
  Tree children=tree.addChild("children");
  children.addChild("c1").setProperty("p","1");
  children.addChild("c2").setProperty("p","2");
  children.addChild("c3").setProperty("p","3");
  children.addChild("c4").setProperty("p","4");
  root.commit();
  Iterator<String> result=executeQuery("select p.[jcr:path], p2.[jcr:path] from [nt:base] as p inner join [nt:base] as p2 on ischildnode(p2, p) where p.[jcr:path] = '/'","JCR-SQL2").iterator();
  assertTrue(result.hasNext());
  assertEquals("/, /children",result.next());
  assertTrue(result.hasNext());
  assertEquals("/, /jcr:system",result.next());
  assertTrue(result.hasNext());
  assertEquals("/, /oak:index",result.next());
  assertTrue(result.hasNext());
  assertEquals("/, /parents",result.next());
  assertFalse(result.hasNext());
}
