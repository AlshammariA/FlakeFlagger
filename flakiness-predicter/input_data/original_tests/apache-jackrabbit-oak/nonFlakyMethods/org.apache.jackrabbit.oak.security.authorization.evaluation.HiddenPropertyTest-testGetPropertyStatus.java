@Test public void testGetPropertyStatus(){
  Tree a=root.getTree("/a");
  for (  String propName : hiddenProps) {
    assertNull(a.getPropertyStatus(propName));
  }
}
