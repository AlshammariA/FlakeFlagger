@Test public void testGetProperty(){
  Tree a=root.getTree("/a");
  for (  String propName : hiddenProps) {
    assertNull(a.getProperty(propName));
  }
}
