@Test public void shouldRemoveImports() throws Exception {
  compareResultsFromFolderUsingProcessor("expectedRemoveImports",createRemoveImportsProcessor());
}
