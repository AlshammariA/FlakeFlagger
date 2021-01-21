@Test public void checkUrlIsAllowed() throws Exception {
  processClasspathResourceType();
  assertFalse(processor.isUriAllowed("/WEB-INF/web.xml"));
  assertTrue(processor.isUriAllowed("classpath:folder/img.gif"));
}
