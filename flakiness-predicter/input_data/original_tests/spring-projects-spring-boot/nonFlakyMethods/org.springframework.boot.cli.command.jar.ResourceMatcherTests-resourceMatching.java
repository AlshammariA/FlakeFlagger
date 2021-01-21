@Test public void resourceMatching() throws IOException {
  ResourceMatcher resourceMatcher=new ResourceMatcher(Arrays.asList("alpha/**","bravo/*","*"),Arrays.asList(".*","alpha/**/excluded"));
  List<MatchedResource> matchedResources=resourceMatcher.find(Arrays.asList(new File("src/test/resources/resource-matcher/one"),new File("src/test/resources/resource-matcher/two"),new File("src/test/resources/resource-matcher/three")));
  System.out.println(matchedResources);
  List<String> paths=new ArrayList<String>();
  for (  MatchedResource resource : matchedResources) {
    paths.add(resource.getName());
  }
  assertEquals(6,paths.size());
  assertTrue(paths.containsAll(Arrays.asList("alpha/nested/fileA","bravo/fileC","fileD","bravo/fileE","fileF","three")));
}
