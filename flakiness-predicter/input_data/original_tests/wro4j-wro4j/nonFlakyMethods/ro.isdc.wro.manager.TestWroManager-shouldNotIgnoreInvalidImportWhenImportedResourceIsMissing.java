@Test(expected=WroRuntimeException.class) public void shouldNotIgnoreInvalidImportWhenImportedResourceIsMissing() throws Exception {
  genericIgnoreMissingResourceTest(false);
}
