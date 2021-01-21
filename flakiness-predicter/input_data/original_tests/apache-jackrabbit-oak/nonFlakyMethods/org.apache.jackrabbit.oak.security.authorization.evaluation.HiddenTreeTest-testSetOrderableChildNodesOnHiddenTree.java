@Test public void testSetOrderableChildNodesOnHiddenTree(){
  try {
    Tree hidden=parent.getChild(hiddenName);
    hidden.setOrderableChildren(true);
    fail("IllegalStateException expected");
  }
 catch (  IllegalStateException e) {
  }
  try {
    Tree hidden=parent.getChild(hiddenName);
    hidden.setOrderableChildren(false);
    fail("IllegalStateException expected");
  }
 catch (  IllegalStateException e) {
  }
}
