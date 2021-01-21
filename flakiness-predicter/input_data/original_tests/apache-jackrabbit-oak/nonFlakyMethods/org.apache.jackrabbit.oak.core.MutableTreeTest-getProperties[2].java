@Test public void getProperties(){
  Tree tree=root.getTree("/");
  Set<PropertyState> expectedProperties=Sets.newHashSet(LongPropertyState.createLongProperty("a",1L),LongPropertyState.createLongProperty("b",2L),LongPropertyState.createLongProperty("c",3L));
  Iterable<? extends PropertyState> properties=tree.getProperties();
  for (  PropertyState property : properties) {
    assertTrue(expectedProperties.remove(property));
  }
  assertTrue(expectedProperties.isEmpty());
  assertEquals(3,tree.getPropertyCount());
}
