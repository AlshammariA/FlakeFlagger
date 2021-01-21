@Test public void testParentOfRoot(){
  TreeLocation rootLocation=TreeLocation.create(root);
  assertEquals(nullLocation,rootLocation.getParent());
}
