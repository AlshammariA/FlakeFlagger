@Test public void testHasProperty(){
  Tree a=root.getTree("/a");
  assertFalse(a.hasProperty(TreeConstants.OAK_CHILD_ORDER));
}
