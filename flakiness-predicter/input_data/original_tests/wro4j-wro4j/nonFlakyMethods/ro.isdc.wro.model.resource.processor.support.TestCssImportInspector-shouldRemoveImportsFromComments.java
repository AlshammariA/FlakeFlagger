@Test public void shouldRemoveImportsFromComments() throws Exception {
  compareResultsFromFolderUsingProcessor("expectedRemoveImportsFromComments",createImportsRemovalProcessor());
}
