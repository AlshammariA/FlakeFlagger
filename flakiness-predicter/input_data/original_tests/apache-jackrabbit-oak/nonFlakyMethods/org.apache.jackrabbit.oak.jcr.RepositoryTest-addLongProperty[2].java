@Test public void addLongProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"long",getAdminSession().getValueFactory().createValue(42L));
}
