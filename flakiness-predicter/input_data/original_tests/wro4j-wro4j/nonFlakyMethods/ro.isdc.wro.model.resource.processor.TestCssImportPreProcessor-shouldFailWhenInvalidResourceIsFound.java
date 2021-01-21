@Test(expected=IOException.class) public void shouldFailWhenInvalidResourceIsFound() throws Exception {
  Context.get().getConfig().setIgnoreMissingResources(false);
  processInvalidImport();
}
