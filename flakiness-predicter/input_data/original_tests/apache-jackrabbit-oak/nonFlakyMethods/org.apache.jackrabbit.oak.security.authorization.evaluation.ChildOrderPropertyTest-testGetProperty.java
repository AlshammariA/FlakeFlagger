@Test public void testGetProperty(){
  Tree a=root.getTree("/a");
  assertNull(a.getProperty(TreeConstants.OAK_CHILD_ORDER));
}
