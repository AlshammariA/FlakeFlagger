@Test public void removeParent(){
  NodeBuilder x=base.builder().getChildNode("x");
  NodeBuilder y=x.setChildNode("y");
  x.remove();
  assertFalse(x.exists());
}
