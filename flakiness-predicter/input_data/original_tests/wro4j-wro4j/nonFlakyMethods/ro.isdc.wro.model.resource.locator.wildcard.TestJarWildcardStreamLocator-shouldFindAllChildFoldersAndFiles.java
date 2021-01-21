@Test public void shouldFindAllChildFoldersAndFiles() throws IOException {
  final ThreadLocal<Collection<String>> filenameListHolder=new ThreadLocal<Collection<String>>();
  final UriLocator uriLocator=createJarLocator(filenameListHolder);
  uriLocator.locate("classpath:com/app/**");
  final Collection<String> filenameList=filenameListHolder.get();
  Assert.assertNotNull(filenameList);
  Assert.assertEquals(Arrays.toString(new String[]{"com/app/level1","com/app/level1/level2","com/app/level1/level2/styles","com/app/level1/level2/styles/style.css","com/app/level1/level2/level2.css","com/app/level1/level1.css"}),Arrays.toString(filenameList.toArray()));
}
