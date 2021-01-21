@Test public void testReplacedStatus3(){
  NodeBuilder x=base.builder().getChildNode("x");
  NodeBuilder q=x.getChildNode("q");
  assertFalse(q.isReplaced());
  x.setChildNode("q").setProperty("a","b");
  assertTrue(q.isReplaced());
}
