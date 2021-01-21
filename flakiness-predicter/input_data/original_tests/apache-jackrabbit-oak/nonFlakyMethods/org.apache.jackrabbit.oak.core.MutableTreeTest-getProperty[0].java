@Test public void getProperty(){
  Tree tree=root.getTree("/");
  PropertyState propertyState=tree.getProperty("any");
  assertNull(propertyState);
  propertyState=tree.getProperty("a");
  assertNotNull(propertyState);
  assertFalse(propertyState.isArray());
  assertEquals(LONG,propertyState.getType());
  assertEquals(1,(long)propertyState.getValue(LONG));
}
