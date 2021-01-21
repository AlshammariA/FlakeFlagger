@Test public void addDateProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"date",getAdminSession().getValueFactory().createValue(Calendar.getInstance()));
}
