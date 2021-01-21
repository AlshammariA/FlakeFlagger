@Test public void testAddRemovedNodeAgain(){
  NodeBuilder root=base.builder();
  root.getChildNode("x").remove();
  NodeBuilder x=root.child("x");
  x.child("q");
  assertTrue(x.hasChildNode("q"));
}
