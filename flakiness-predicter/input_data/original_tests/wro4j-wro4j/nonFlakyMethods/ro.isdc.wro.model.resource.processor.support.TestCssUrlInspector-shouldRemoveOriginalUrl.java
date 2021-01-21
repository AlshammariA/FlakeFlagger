@Test public void shouldRemoveOriginalUrl() throws Exception {
  compareResultsFromFolderUsingProcessor("expectedEmptyReplace",createProcessorWithHandler(new ItemHandler(){
    public String replace(    final String originalDeclaration,    final String originalUrl){
      return originalDeclaration.replace(originalUrl,"");
    }
  }
));
}
