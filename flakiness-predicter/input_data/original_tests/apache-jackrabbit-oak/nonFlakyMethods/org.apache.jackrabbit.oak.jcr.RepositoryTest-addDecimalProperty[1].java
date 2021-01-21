@Test public void addDecimalProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"decimal",getAdminSession().getValueFactory().createValue(BigDecimal.valueOf(21)));
}
