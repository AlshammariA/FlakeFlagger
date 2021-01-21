@Test public void testCreateHiddenProperty3(){
  Tree a=root.getTree("/a");
  try {
    PropertyState propertyState=PropertyBuilder.scalar(STRING).setName(":hiddenProperty").setValue("val").getPropertyState();
    a.setProperty(propertyState);
    root.commit();
    fail();
  }
 catch (  Exception e) {
  }
}
