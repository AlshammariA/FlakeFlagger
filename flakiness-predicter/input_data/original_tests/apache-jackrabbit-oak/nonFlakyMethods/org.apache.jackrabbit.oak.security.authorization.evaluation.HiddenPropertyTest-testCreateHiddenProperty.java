@Test public void testCreateHiddenProperty(){
  Tree a=root.getTree("/a");
  try {
    a.setProperty(":hiddenProperty","val");
    root.commit();
    fail();
  }
 catch (  Exception e) {
  }
}
