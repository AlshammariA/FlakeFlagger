@Test public void shouldCorrectlyDetectImport() throws Exception {
  assertImportDetected("@import(child/style.css);","/css/child/style.css");
}
