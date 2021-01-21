@Test public void testOrderBeforeOnHiddenTree(){
  try {
    Tree hidden=parent.getChild(hiddenName);
    hidden.orderBefore("someother");
    fail("IllegalStateException expected");
  }
 catch (  IllegalStateException e) {
  }
}
