@Test public void query() throws Exception {
  Tree t=root.getTree("/");
  t.addChild("a").addChild("n").setProperty("myProp","foo");
  t.addChild("b").addChild("n").setProperty("myProp","bar");
  t.addChild("c").addChild("x").setProperty("myProp","foo");
  t.setProperty("myProp","foo");
  root.commit();
  setTravesalEnabled(false);
  assertQuery("select [jcr:path] from [nt:base] where [n/myProp] is not null",ImmutableList.of("/a","/b"));
  List<String> lines=executeQuery("explain select [jcr:path] from [nt:base] where [n/myProp] is not null",Query.JCR_SQL2);
  assertEquals(1,lines.size());
  assertTrue(lines.get(0).contains("property myProp"));
  assertQuery("select [jcr:path] from [nt:base] where [n/myProp] = 'foo'",ImmutableList.of("/a"));
  setTravesalEnabled(false);
}
