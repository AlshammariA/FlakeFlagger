@Test public void testCreateHiddenProperty2(){
  Tree a=root.getTree("/a");
  try {
    a.setProperty(":hiddenProperty","val",NAME);
    root.commit();
    fail();
  }
 catch (  Exception e) {
  }
}
