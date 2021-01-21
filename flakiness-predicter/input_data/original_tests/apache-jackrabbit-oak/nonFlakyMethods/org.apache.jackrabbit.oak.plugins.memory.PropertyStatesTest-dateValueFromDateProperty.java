@Test public void dateValueFromDateProperty() throws RepositoryException {
  String expected=ISO8601.format(Calendar.getInstance());
  PropertyState dateProperty=PropertyStates.createProperty("date",expected,Type.DATE);
  String actual=dateProperty.getValue(Type.DATE);
  assertEquals(expected,actual);
}
