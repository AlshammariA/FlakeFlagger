@Test public void setProperty() throws CommitFailedException {
  Tree tree=root.getTree("/");
  assertFalse(tree.hasProperty("new"));
  tree.setProperty("new","value");
  PropertyState property=tree.getProperty("new");
  assertNotNull(property);
  assertEquals("new",property.getName());
  assertEquals("value",property.getValue(STRING));
  root.commit();
  property=tree.getProperty("new");
  assertNotNull(property);
  assertEquals("new",property.getName());
  assertEquals("value",property.getValue(STRING));
}
