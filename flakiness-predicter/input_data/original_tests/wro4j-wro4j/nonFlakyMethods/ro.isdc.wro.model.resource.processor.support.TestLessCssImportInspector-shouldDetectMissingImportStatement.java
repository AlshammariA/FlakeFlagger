@Test public void shouldDetectMissingImportStatement(){
  assertFalse(createCssImportInspector("#someId {color: red}").containsImport());
  assertFalse(createCssImportInspector("#import {display: block}").containsImport());
}
