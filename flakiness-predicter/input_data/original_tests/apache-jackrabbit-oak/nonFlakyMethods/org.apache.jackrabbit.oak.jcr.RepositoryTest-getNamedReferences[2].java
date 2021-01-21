@Test public void getNamedReferences() throws RepositoryException {
  Session session=getAdminSession();
  Node referee=getNode("/foo");
  referee.addMixin("mix:referenceable");
  Value value=session.getValueFactory().createValue(referee);
  getNode(TEST_PATH).setProperty("reference1",value);
  getNode("/bar").setProperty("reference2",value);
  session.save();
  PropertyIterator refs=referee.getReferences("reference1");
  assertTrue(refs.hasNext());
  Property p=refs.nextProperty();
  assertEquals("reference1",p.getName());
  assertFalse(refs.hasNext());
}
