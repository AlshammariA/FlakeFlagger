@Test public void testWriteOnRemoveNode(){
  for (  String name : new String[]{"x","new"}) {
    NodeBuilder root=base.builder();
    NodeBuilder child=root.child(name);
    root.getChildNode(name).remove();
    try {
      child.setProperty("q","w");
      fail();
    }
 catch (    IllegalStateException e) {
    }
    root.child(name);
    assertEquals(0,child.getChildNodeCount(1));
  }
}
