@Test public void saveOnChangedProperty() throws RepositoryException {
  prop0.setValue("changed");
  prop0.save();
  prop1.setValue("changed");
  prop1.save();
}
