@Test public void testHasProperty(){
  Tree a=root.getTree("/a");
  for (  String propName : hiddenProps) {
    assertFalse(a.hasProperty(propName));
  }
}
