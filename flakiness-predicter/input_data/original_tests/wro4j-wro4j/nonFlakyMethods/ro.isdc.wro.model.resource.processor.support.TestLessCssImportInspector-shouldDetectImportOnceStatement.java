@Test public void shouldDetectImportOnceStatement(){
  assertHasImport("@import-once url('import/blue-theme.less'");
  assertHasImport("@import-once 'import/blue-theme.less'");
}
