@Test public void shouldCorrectlyDetectImportWithDoubleQuotes() throws Exception {
  assertImportDetected("@import(\"child/style.css\");","/css/child/style.css");
}
