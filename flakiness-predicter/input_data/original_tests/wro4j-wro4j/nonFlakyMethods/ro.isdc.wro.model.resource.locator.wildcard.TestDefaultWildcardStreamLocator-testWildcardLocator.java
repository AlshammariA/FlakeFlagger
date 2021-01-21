@Test public void testWildcardLocator() throws IOException {
  locator=new DefaultWildcardStreamLocator(){
    @Override void triggerWildcardExpander(    final Collection<File> allFiles,    final WildcardContext wildcardContext) throws IOException {
      Assert.assertEquals(2,allFiles.size());
    }
  }
;
  final UriLocator uriLocator=new ClasspathUriLocator(){
    @Override public WildcardStreamLocator newWildcardStreamLocator(){
      return locator;
    }
  }
;
  uriLocator.locate("classpath:" + WroUtil.toPackageAsFolder(getClass()) + "/*.css");
}
