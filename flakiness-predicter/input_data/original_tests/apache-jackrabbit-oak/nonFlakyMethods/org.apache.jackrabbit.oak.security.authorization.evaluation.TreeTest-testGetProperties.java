@Test public void testGetProperties() throws Exception {
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  testRoot.refresh();
  Tree a=testRoot.getTree("/a");
  Iterable<? extends PropertyState> props=a.getProperties();
  assertFalse(props.iterator().hasNext());
}
