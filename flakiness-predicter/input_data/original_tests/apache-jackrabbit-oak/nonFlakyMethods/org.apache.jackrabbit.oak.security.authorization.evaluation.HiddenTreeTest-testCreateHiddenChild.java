@Test public void testCreateHiddenChild(){
  try {
    Tree hidden=parent.addChild(":hiddenChild");
    root.commit();
    fail();
  }
 catch (  Exception e) {
  }
}
