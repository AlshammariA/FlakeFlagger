@Test public void shouldFindImports() throws Exception {
  compareResultsFromFolderUsingProcessor("expectedFindImports",createFindImportsProcessor());
}
