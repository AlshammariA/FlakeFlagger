@Test public void testGetPropertyStatus(){
  Tree a=root.getTree("/a");
  assertNull(a.getPropertyStatus(TreeConstants.OAK_CHILD_ORDER));
}
