@Test public void testGetPropertyCount(){
  Tree a=root.getTree("/a");
  assertEquals(2,a.getPropertyCount());
}
