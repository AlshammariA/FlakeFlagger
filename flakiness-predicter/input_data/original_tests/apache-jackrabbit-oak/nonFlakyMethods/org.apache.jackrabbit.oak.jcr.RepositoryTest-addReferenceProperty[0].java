@Test public void addReferenceProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  Node referee=getAdminSession().getNode("/foo");
  referee.addMixin("mix:referenceable");
  getAdminSession().save();
  addProperty(parentNode,"reference",getAdminSession().getValueFactory().createValue(referee));
}
