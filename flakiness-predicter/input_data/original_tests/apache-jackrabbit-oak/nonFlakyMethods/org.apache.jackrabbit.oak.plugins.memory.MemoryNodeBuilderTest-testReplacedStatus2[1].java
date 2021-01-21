@Test public void testReplacedStatus2(){
  NodeBuilder x=base.builder().getChildNode("x");
  NodeBuilder q=x.getChildNode("q");
  q.remove();
  assertFalse(q.isReplaced());
  x.setChildNode("q").setProperty("a","b");
  assertTrue(q.isReplaced());
}
