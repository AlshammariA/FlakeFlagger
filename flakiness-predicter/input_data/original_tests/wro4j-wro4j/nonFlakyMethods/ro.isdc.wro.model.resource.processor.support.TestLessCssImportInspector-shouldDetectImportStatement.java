@Override @Test public void shouldDetectImportStatement(){
  assertHasImport("@import 'style.css'");
  assertHasImport("@import url(\"import/blue-theme.css?id=123\");");
  assertHasImport("@import-multiple url(import/blue-theme.css) screen and (max-width: 400px);");
  assertHasImport("@import \"import/blue-theme.css\" screen and (max-width: 400px);");
  assertHasImport("@import 'import/blue-theme.less' handheld;");
  assertHasImport("@import 'import/blue-theme.less';");
}
