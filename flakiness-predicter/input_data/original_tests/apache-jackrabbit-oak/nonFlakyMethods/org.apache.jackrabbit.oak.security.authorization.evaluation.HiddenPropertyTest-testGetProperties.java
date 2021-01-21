@Test public void testGetProperties(){
  Set<String> propertyNames=Sets.newHashSet(JcrConstants.JCR_PRIMARYTYPE,"aProp");
  Tree a=root.getTree("/a");
  for (  PropertyState prop : a.getProperties()) {
    assertTrue(propertyNames.remove(prop.getName()));
  }
  assertTrue(propertyNames.isEmpty());
}
