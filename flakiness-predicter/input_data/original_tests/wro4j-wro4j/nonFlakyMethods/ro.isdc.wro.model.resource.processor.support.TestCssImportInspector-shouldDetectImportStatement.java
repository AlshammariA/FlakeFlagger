@Test public void shouldDetectImportStatement(){
  assertHasImport("@import 'style.css'");
  assertHasImport("@import url(style.css)");
}
