@Test public void testGetAllIdentifiers() throws Exception {
  File testDir=new File("./target","oak-fds-test");
  FileUtils.touch(new File(testDir,"a"));
  FileUtils.touch(new File(testDir,"b"));
  FileUtils.touch(new File(testDir,"adir/c"));
  FileDataStore fds=new OakFileDataStore();
  fds.setPath(testDir.getAbsolutePath());
  fds.init(null);
  Iterator<DataIdentifier> dis=fds.getAllIdentifiers();
  Set<String> fileNames=Sets.newHashSet(Iterators.transform(dis,new Function<DataIdentifier,String>(){
    @Override public String apply(    @Nullable DataIdentifier input){
      return input.toString();
    }
  }
));
  Set<String> expectedNames=Sets.newHashSet("a","b","c");
  assertEquals(expectedNames,fileNames);
  FileUtils.cleanDirectory(testDir);
}
